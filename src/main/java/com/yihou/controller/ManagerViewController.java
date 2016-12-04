/**
 * 版权所有：恒生电子股份有限公司 保留所有权利
 * 版本： 1.0
 * ******************************************
 * Copyright (c)  by Hundsun ,Ltd.
 * All right reserved.
 * Last version:  1.0
 */
package com.yihou.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.yihou.dao.ManagerViewDao;
import com.yihou.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/manager")
public class ManagerViewController {

    @Autowired
    private ManagerViewDao managerViewDao;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
    }

    @RequestMapping("/managerView")
    public String manageView() {
        return "/managerView";
    }

    @RequestMapping("/view")
    @ResponseBody
    public String view(Date beginDate, Date endDate) {
        Map<String, Object> params = new HashMap<String, Object>();
        if (beginDate != null) {
            Calendar beginCalendar = Calendar.getInstance();
            beginCalendar.setTime(beginDate);
            beginCalendar.add(Calendar.HOUR_OF_DAY, 8);
            params.put("beginDate", beginCalendar.getTime());
        }
        if (endDate != null) {
            endDate = DateUtil.addDay(endDate, 1);
            Calendar endCalendar = Calendar.getInstance();
            endCalendar.setTime(endDate);
            endCalendar.add(Calendar.HOUR_OF_DAY, 8);
            params.put("endDate", endCalendar.getTime());
        }
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        Map<String, Object> asmInTotal = managerViewDao.findAsmInTotal(params);
        Map<String, Object> asmInTotalTemp = new HashMap<String, Object>();
        asmInTotalTemp.put("name", "胚布入库");
        asmInTotalTemp.put("total", asmInTotal == null || asmInTotal.isEmpty() || asmInTotal.get("Weights") == null ? "0" : asmInTotal.get("Weights"));
        mapList.add(asmInTotalTemp);

        Map<String, Object> asmOutTotal = managerViewDao.findAsmOutTotal(params);
        Map<String, Object> asmOutTotalTemp = new HashMap<String, Object>();
        asmOutTotalTemp.put("name", "胚布出库");
        asmOutTotalTemp.put("total", asmOutTotal == null || asmOutTotal.isEmpty() || asmOutTotal.get("Weights") == null ? "0" : asmOutTotal.get("Weights"));
        mapList.add(asmOutTotalTemp);

        Map<String, Object> fabInTotal = managerViewDao.findFabInTotal(params);
        Map<String, Object> fabInTotalTemp = new HashMap<String, Object>();
        fabInTotalTemp.put("name", "成品入库");
        fabInTotalTemp.put("total", fabInTotal == null || fabInTotal.isEmpty() || fabInTotal.get("Weights") == null ? "0" : fabInTotal.get("Weights"));
        mapList.add(fabInTotalTemp);

        Map<String, Object> fabOutTotal = managerViewDao.findFabOutTotal(params);
        Map<String, Object> fabOutTotalTemp = new HashMap<String, Object>();
        fabOutTotalTemp.put("name", "成品出库");
        fabOutTotalTemp.put("total", fabOutTotal == null || fabOutTotal.isEmpty() || fabOutTotal.get("Weights") == null ? "0" : fabOutTotal.get("Weights"));
        mapList.add(fabOutTotalTemp);

        Map<String, Object> comeQuanTotal = managerViewDao.findComeQuanTotal(params);
        Map<String, Object> comeQuanTotalTemp = new HashMap<String, Object>();
        comeQuanTotalTemp.put("name", "当天来样");
        comeQuanTotalTemp.put("total", comeQuanTotal == null || comeQuanTotal.isEmpty() || comeQuanTotal.get("Weights") == null ? "0" : comeQuanTotal.get("Weights"));
        mapList.add(comeQuanTotalTemp);

        Map<String, Object> replySamTotal = managerViewDao.findReplySamTotal(params);
        Map<String, Object> replySamTotalTemp = new HashMap<String, Object>();
        replySamTotalTemp.put("name", "当天复样");
        replySamTotalTemp.put("total", replySamTotal == null || replySamTotal.isEmpty() || replySamTotal.get("Weights") == null ? "0" : replySamTotal.get("Weights"));
        mapList.add(replySamTotalTemp);

        Map<String, Object> manuCountAndManuQuanTotal = managerViewDao.findManuCountAndManuQuan(params);
        Map<String, Object> manuCountTotalTemp = new HashMap<String, Object>();
        manuCountTotalTemp.put("name", "当天开卡");
        manuCountTotalTemp.put("total", manuCountAndManuQuanTotal == null || manuCountAndManuQuanTotal.isEmpty() || manuCountAndManuQuanTotal.get("ManuCount") == null ? "0" : manuCountAndManuQuanTotal.get("ManuCount"));
        mapList.add(manuCountTotalTemp);

        Map<String, Object> manuQuanTotalTemp = new HashMap<String, Object>();
        manuQuanTotalTemp.put("name", "开卡总量");
        manuQuanTotalTemp.put("total", manuCountAndManuQuanTotal == null || manuCountAndManuQuanTotal.isEmpty() || manuCountAndManuQuanTotal.get("ManuQuan") == null ? "0" : manuCountAndManuQuanTotal.get("ManuQuan"));
        mapList.add(manuQuanTotalTemp);

        List<Map<String, Object>> scanProcedureList = managerViewDao.findScanProcedure(params);

        boolean scan0002isNull = true;
        boolean scan0006isNull = true;
        boolean scan0022isNull = true;
        boolean scan0024isNull = true;
        boolean scan0026isNull = true;
        boolean scan0004isNull = true;
        boolean scan0003isNull = true;
        boolean scan0017isNull = true;
        boolean scan0019isNull = true;
        boolean scan0011isNull = true;
        boolean scan0028isNull = true;


        if (scanProcedureList != null && !scanProcedureList.isEmpty()) {
            for (Map<String, Object> scanProcedure : scanProcedureList) {
                if ("0002".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "松布产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0002isNull = false;
                } else if ("0006".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "坯定产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0006isNull = false;
                } else if ("0022".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "拉毛产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0022isNull = false;
                } else if ("0024".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "剪毛产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0024isNull = false;
                } else if ("0026".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "磨毛产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0026isNull = false;
                } else if ("0004".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "汽蒸产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0004isNull = false;
                } else if ("0003".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "开幅产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0003isNull = false;
                } else if ("0017".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "色布开幅");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0017isNull = false;
                } else if ("0019".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "色布开幅2");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0019isNull = false;
                } else if ("0011".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "染色产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0011isNull = false;
                } else if ("0028".equals(String.valueOf(scanProcedure.get("ProcedureCode")))) {
                    Map<String, Object> tempMap = new HashMap<String, Object>();
                    tempMap.put("name", "定型产量");
                    tempMap.put("total", scanProcedure.get("Quan") == null ? "0" : scanProcedure.get("Quan"));
                    mapList.add(tempMap);
                    scan0028isNull = false;
                }
            }
        }
        if (scan0002isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "松布产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0006isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "坯定产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0022isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "剪毛产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0024isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "剪毛产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0026isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "汽蒸产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0004isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "汽蒸产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0003isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "开幅产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0017isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "色布开幅");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0019isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "色布开幅2");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0011isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "染色产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        if (scan0028isNull) {
            Map<String, Object> tempMap = new HashMap<String, Object>();
            tempMap.put("name", "定型产量");
            tempMap.put("total", "0");
            mapList.add(tempMap);
        }
        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd";
        return JSON.toJSONString(mapList, SerializerFeature.WriteDateUseDateFormat);
    }

}
