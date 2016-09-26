package com.yihou.service;

import com.yihou.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by YuPan on 2016/8/18.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Boolean userLogin(Map<String,Object> params,HttpSession session) {
        Map<String, Object> user = userDao.findCustomer(params);
        if (user != null) {
            // 表示登录用户为客户
            session.setAttribute("LOGIN_USER_TYPE","1");
            return true;
        } else {
            user = userDao.findOne(params);
            if (user != null) {
                // 表示登录用户为用户
                session.setAttribute("LOGIN_USER_TYPE","2");
                return true;
            }
        }
        return false;
    }

}
