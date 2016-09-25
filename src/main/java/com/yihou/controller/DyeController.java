package com.yihou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yihou.model.SqlPage;
import com.yihou.service.DyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dye")
public class DyeController {

    @Autowired
    private DyeService dyeService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("/dyeMachineD")
    public String dyeMachineD() {
        return "dyeMachineD";
    }

    @RequestMapping("/findDyeMachineD")
    @ResponseBody
    public String findDyeMachineD(String manuCrock, int page, int rows, String order, HttpSession session) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("manuCrock", manuCrock);
        Object loginUserType = session.getAttribute("LOGIN_USER_TYPE");
        if (loginUserType != null && loginUserType.toString().equals("1")) {
            params.put("ParComID", session.getAttribute("LOGIN_USER"));
        }
        SqlPage sqlPage = new SqlPage();
        sqlPage.setPage(page);
        sqlPage.setRows(rows);
        sqlPage.setOrder(order);
        List<Map<String, Object>> mapList = dyeService.findDyeMachineD(params, sqlPage);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(mapList, SerializerFeature.WriteDateUseDateFormat);
    }
}
