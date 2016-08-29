package com.yihou.controller;

import com.yihou.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("/findProductInHead")
    @ResponseBody
    public String findAsmInHead(Date beginDate, Date endDate,String customerName,int page,int rows,String order) {
        return null;
    }

    @RequestMapping("/findProductOutHead")
    @ResponseBody
    public String findAsmOutHead(Date beginDate, Date endDate,int page,int rows,String order) {
        return null;
    }

    @RequestMapping("/findProductSave")
    @ResponseBody
    public String findAsmSave(Date beginDate, Date endDate,int page,int rows,String order) {
        return null;
    }
}
