package com.yihou.controller;

import com.yihou.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UrlController {

    /**
     * 系统主页
     *
     * @return
     */
    @RequestMapping("/")
    public String index() {
        return "/index";
    }

    /**
     * 登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/login";
    }

    /**
     * 胚布入库页面
     * @return
     */
    @RequestMapping("/asmIn")
    public String asmIn() {
        return "/asmIn";
    }

    @RequestMapping("/asmOut")
    public String asmOut() {
        return "/asmOut";
    }
}
