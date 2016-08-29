package com.yihou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yihou.model.SqlPage;
import com.yihou.service.FabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/fab")
public class FabController {

    @Autowired
    private FabService fabService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("/findFabInHead")
    @ResponseBody
    public String findAsmInHead(Date beginDate, Date endDate,String customerName,int page,int rows,String order) {
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("beginDate", beginDate);
        params.put("endDate", endDate);
        params.put("customerName", customerName);
        SqlPage sqlPage = new SqlPage();
        sqlPage.setPage(page);
        sqlPage.setRows(rows);
        sqlPage.setOrder(order);
        List<Map<String, Object>> mapList = fabService.findFabInHead(params, sqlPage);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(mapList, SerializerFeature.WriteDateUseDateFormat);
    }

    @RequestMapping("/findFabOutHead")
    @ResponseBody
    public String findAsmOutHead(Date beginDate, Date endDate,String customerName,int page,int rows,String order) {
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("beginDate", beginDate);
        params.put("endDate", endDate);
        params.put("customerName", customerName);
        SqlPage sqlPage = new SqlPage();
        sqlPage.setPage(page);
        sqlPage.setRows(rows);
        sqlPage.setOrder(order);
        List<Map<String, Object>> mapList = fabService.findFabOutHead(params, sqlPage);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(mapList, SerializerFeature.WriteDateUseDateFormat);
    }

    @RequestMapping("/findFabSave")
    @ResponseBody
    public String findFabSave(Date beginDate, Date endDate,int page,int rows,String order) {
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("beginDate", beginDate);
        params.put("endDate", endDate);
        SqlPage sqlPage = new SqlPage();
        sqlPage.setPage(page);
        sqlPage.setRows(rows);
        sqlPage.setOrder(order);
        List<Map<String, Object>> mapList = fabService.findFabSave(params, sqlPage);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(mapList, SerializerFeature.WriteDateUseDateFormat);
    }
}
