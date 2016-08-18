package com.yihou.controller;

import com.yihou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public Boolean userLogin(String userName,String userPwd) {
        Map<String, Object> params = new HashMap<>();
        params.put("userName",userName);
        params.put("userPwd", userPwd);
        return userService.userLogin(params);
    }

}
