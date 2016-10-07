package com.yihou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yihou.model.SqlPage;
import com.yihou.service.MatService;
import com.yihou.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/mat")
public class MatController {

    @Autowired
    private MatService matService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("/matIn")
    public String maIn() {
        return "matIn";
    }

    @RequestMapping("/matOut")
    public String maOut() {
        return "matOut";
    }

    @RequestMapping("/findMatInHead")
    @ResponseBody
    public String findMatInHead(Date beginDate, Date endDate, String customerName, String maName, int page, int rows, String order) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("beginDate", beginDate);
        params.put("endDate", DateUtil.addDay(endDate, 1));
        params.put("customerName", customerName);
        params.put("maName", maName);
        SqlPage sqlPage = new SqlPage();
        sqlPage.setPage(page);
        sqlPage.setRows(rows);
        sqlPage.setOrder(order);
        List<Map<String, Object>> mapList = matService.findMatInHead(params, sqlPage);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(mapList, SerializerFeature.WriteDateUseDateFormat);
    }

    @RequestMapping("/matInDetail/{matInNo}")
    public String matInDetail(@PathVariable("matInNo") String matInNo, ModelMap model) {
        model.addAttribute("matInNo", matInNo);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("matInNo", matInNo);
        List<Map<String, Object>> mapList = matService.findMatInDetail(params);
        if (mapList != null && !mapList.isEmpty()) {
            model.addAttribute("head", mapList.get(0));
            model.addAttribute("detail", mapList);
        }
        return "/matInDetail";
    }

    @RequestMapping("/findMatOutHead")
    @ResponseBody
    public String findMatOutHead(Date beginDate, Date endDate, String customerName, String maName, int page, int rows, String order) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("beginDate", beginDate);
        params.put("endDate", DateUtil.addDay(endDate, 1));
        params.put("customerName", customerName);
        params.put("maName", maName);
        SqlPage sqlPage = new SqlPage();
        sqlPage.setPage(page);
        sqlPage.setRows(rows);
        sqlPage.setOrder(order);
        List<Map<String, Object>> mapList = matService.findMatOutHead(params, sqlPage);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(mapList, SerializerFeature.WriteDateUseDateFormat);
    }

    @RequestMapping("/matOutDetail/{matOutNo}")
    public String matOutDetail(@PathVariable("matOutNo") String matOutNo, ModelMap model) {
        model.addAttribute("matOutNo", matOutNo);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("matOutNo", matOutNo);
        List<Map<String, Object>> mapList = matService.findMatOutDetail(params);
        if (mapList != null && !mapList.isEmpty()) {
            model.addAttribute("head", mapList.get(0));
            model.addAttribute("detail", mapList);
        }
        return "/matOutDetail";
    }

    @RequestMapping("/matSave")
    public String matSave() {
        return "matSave";
    }

    @RequestMapping("/findMatSave")
    @ResponseBody
    public String findMatSave(String matYear,String matMonth,String prodNameC,int page, int rows, String order) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("matYear", matYear);
        params.put("matMonth", matMonth);
        params.put("prodNameC", prodNameC);
        SqlPage sqlPage = new SqlPage();
        sqlPage.setPage(page);
        sqlPage.setRows(rows);
        sqlPage.setOrder(order);
        List<Map<String, Object>> mapList = matService.findMatSave(params,sqlPage);
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(mapList, SerializerFeature.WriteDateUseDateFormat);
    }

}
