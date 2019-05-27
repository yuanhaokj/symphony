package org.b3log.symphony.spring.controller.user;



import com.google.gson.Gson;
import org.b3log.symphony.spring.model.UserInfoModel;
import org.b3log.symphony.spring.service.frontend.UserService;
import org.python.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("api/user/")
public class UserController {


    private static Logger LOG = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object>
    login(@RequestBody String userInfoBody,
          HttpServletRequest request,
          Model model,
          HttpServletResponse resp)
            throws Exception {
        Map<String, Object> returnMap = new HashMap<>();

        UserInfoModel tempUserInfo = new Gson().fromJson(userInfoBody, UserInfoModel.class);

        if (null != tempUserInfo.getUsername() && !Strings.isNullOrEmpty(tempUserInfo.getUsername())
                && !tempUserInfo.getUsername().equals("NULL")
                && !tempUserInfo.getUsername().equals("null")
                && !tempUserInfo.getUsername().equals("")) {
            UserInfoModel userInfoModel = userService.findPasswordByName(tempUserInfo.getUsername());
            if (userInfoModel == null) {
                returnMap.put("success", false);
                returnMap.put("msg", "还未注册，请先注册");
                return returnMap;
            }
            if (userInfoModel.getPassword() != null && !userInfoModel.getPassword().equals("")) {
                if (userInfoModel.getPassword().equals(tempUserInfo.getPassword())) {
                    returnMap.put("success", true);
                    returnMap.put("msg", "登陆成功");
                    return returnMap;
                } else {
                    returnMap.put("success", false);
                    returnMap.put("msg", "账号密码错误");
                    return returnMap;
                }
            } else {
                returnMap.put("success", false);
                returnMap.put("msg", "请先注册");
                return returnMap;
            }
        } else if (null != tempUserInfo.getPhoneNumber() && !Strings.isNullOrEmpty(tempUserInfo.getPhoneNumber())
                && !tempUserInfo.getPhoneNumber().equals("NULL")
                && !tempUserInfo.getPhoneNumber().equals("null")
                && !tempUserInfo.getPhoneNumber().equals("")) {
            UserInfoModel userInfoModel = userService.findPasswordByPhoneNumber(tempUserInfo.getPhoneNumber());
            if (userInfoModel == null) {
                returnMap.put("success", false);
                returnMap.put("msg", "还未注册，请先注册");
                return returnMap;
            }
            if (userInfoModel.getPassword().equals(tempUserInfo.getPassword())) {
                returnMap.put("success", true);
                returnMap.put("msg", "登陆成功");
                return returnMap;
            } else {
                returnMap.put("success", false);
                returnMap.put("msg", "电话号码或密码错误");
                return returnMap;
            }
        } else {
            returnMap.put("success", false);
            returnMap.put("msg", "还未注册，请先注册");
            return returnMap;
        }
    }


    @RequestMapping(value = "sign/in", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object>
    signIn(@RequestBody String userInfoBody,
           HttpServletRequest request,
           Model model,
           HttpServletResponse resp)
            throws Exception {
        Map<String, Object> returnMap = new HashMap<>();

        UserInfoModel tempUserInfo = new Gson().fromJson(userInfoBody, UserInfoModel.class);
        if (tempUserInfo != null) {
            UserInfoModel userInfoModel = userService.findPasswordByName(tempUserInfo.getUsername());
            if (userInfoModel != null) {
                returnMap.put("success", false);
                returnMap.put("msg", "用户名已存在");
                return returnMap;
            }
            UserInfoModel userInfoModelPhone = userService.findPasswordByPhoneNumber(tempUserInfo.getPhoneNumber());
            if (userInfoModelPhone != null) {
                returnMap.put("success", false);
                returnMap.put("msg", "电话号码已存在");
                return returnMap;
            }
            userService.save(tempUserInfo);
            returnMap.put("success", true);
            returnMap.put("msg", "注册成功");
            return returnMap;
        } else {
            userService.save(tempUserInfo);
            returnMap.put("success", false);
            returnMap.put("msg", "未收到注册信息");
        }
        returnMap.put("success", true);
        returnMap.put("msg", "注册成功");
        return returnMap;
    }

}
