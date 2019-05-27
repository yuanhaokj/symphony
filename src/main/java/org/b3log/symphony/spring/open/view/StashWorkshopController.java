package org.b3log.symphony.spring.open.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;

/**
 * 编排与开发
 * @author LiShun
 * @date 2019-03-20
 */
@Controller
@RequestMapping("")
public class StashWorkshopController {

    @RequestMapping("/index")
    public String workshop() {
        return "main/workshop/alumni/index";
    }

    @RequestMapping("login")
    public String signIn() {
        return "main/workshop/login/login";
    }

    @RequestMapping("signUp")
    public String signUp() {
        return "main/workshop/signUp/signUp";
    }

    @RequestMapping("file")
    public String workshopFile() {
        return "main/workshop/file/file";
    }

    @RequestMapping("alumni")
    public String workshopAlumni() {
        return "main/workshop/alumni/index";
    }


    @RequestMapping("stock")
    public String stockDetail() {
        return "main/workshop/stockdetail/stockdetail";
    }


    @RequestMapping("python")
    public String python() {
        return "main/workshop/python/python";
    }


    @RequestMapping("userMain")
    public String userMain() {
        return "main/workshop/userMain/userMain";
    }

    @RequestMapping("")
    public String main() {
        return "main/workshop/main/main";
    }

//    @RequestMapping("common")
//    public String workshopAlumni() {
//        return "main/workshop/alumni/index";
//    }

}
