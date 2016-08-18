package com.yihou.service;

import com.yihou.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by YuPan on 2016/8/18.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public Boolean userLogin(Map<String,Object> params) {
        Map<String, Object> user = userDao.findOne(params);
        if (user != null) {
            return true;
        }
        return false;
    }

}
