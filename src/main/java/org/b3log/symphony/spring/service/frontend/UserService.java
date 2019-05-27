package org.b3log.symphony.spring.service.frontend;


import org.apache.commons.lang.RandomStringUtils;
import org.b3log.symphony.spring.dao.UserInfoDao;
import org.b3log.symphony.spring.model.UserInfoModel;
import org.b3log.symphony.spring.util.DesUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfoModel findPasswordByName(String username){
        UserInfoModel model = userInfoDao.findByUserName(username);
        if (model == null){
            return null;
        }
        //解密
        String password = DesUtil.decryptBasedDes(model.getPassword());
        model.setPassword(password);
        return model;
    }

    public UserInfoModel findPasswordByPhoneNumber(String phoneNumber){
        UserInfoModel model = userInfoDao.findByPhoneNumber(phoneNumber);
        if (model == null){
            return null;
        }
        //解密
        String password = DesUtil.decryptBasedDes(model.getPassword());
        model.setPassword(password);
        return model;
    }


    public void save(UserInfoModel model){
        model.setId(RandomStringUtils.randomAlphanumeric(64).toLowerCase());
        //加密
        String password = DesUtil.encryptBasedDes(model.getPassword());
        model.setPassword(password);
        userInfoDao.save(model);
    }


}
