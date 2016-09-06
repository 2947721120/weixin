package com.yihou.controller;

import com.yihou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/userLogin")
    @ResponseBody
    public Boolean userLogin(String userName, String userPwd,HttpSession session) {
        Map<String, Object> params = new HashMap<>();
        params.put("userName", userName);
        params.put("userPwd", userPwd);
        boolean b = userService.userLogin(params);
        if (b) {
            session.setAttribute("LOGIN_USER", params);
        } else {
            session.removeAttribute("LOGIN_USER");
        }
        return b;
    }

}
