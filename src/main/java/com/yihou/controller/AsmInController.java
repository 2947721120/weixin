package com.yihou.controller;

import com.yihou.model.SqlPage;
import com.yihou.service.AsmInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/asmIn")
public class AsmInController {

    @Autowired
    private AsmInService asmInService;

    @RequestMapping("/findAsmInHead")
    @ResponseBody
    public List<Map<String, Object>> findAsmInHead(Date beginDate, Date endDate,int page,int rows,String order) {
        Map<String, Object> params = new HashMap<String,Object>();
        params.put("beginDate", beginDate);
        params.put("endDate", endDate);
        SqlPage sqlPage = new SqlPage();
        sqlPage.setPage(page);
        sqlPage.setRows(rows);
        sqlPage.setOrder(order);
        return asmInService.findAsmInHead(params,sqlPage);
    }
}
