package com.yihou.controller;

import com.yihou.service.AsmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UrlController {

    @Autowired
    private AsmService asmService;

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

    @RequestMapping("/asmInDetail/{asmNo}")
    public String asmInDetail(@PathVariable("asmNo") String asmNo, ModelMap model){
        model.addAttribute("asmNo", asmNo);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("asmNo", asmNo);
        List<Map<String, Object>> mapList = asmService.findAsmInDetail(params);
        if (mapList != null && !mapList.isEmpty()) {
            model.addAttribute("head", mapList.get(0));
            model.addAttribute("detail", mapList);
        }
        return "/asmInDetail";
    }

    @RequestMapping("/asmOutDetail/{asmNo}")
    public String asmOutDetail(@PathVariable("asmNo") String asmNo, ModelMap model) {
        model.addAttribute("asmNo", asmNo);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("asmNo", asmNo);
        List<Map<String, Object>> mapList = asmService.findAsmOutDetail(params);
        if (mapList != null && !mapList.isEmpty()) {
            model.addAttribute("head", mapList.get(0));
            model.addAttribute("detail", mapList);
        }
        return "/asmOutDetail";
    }

}
