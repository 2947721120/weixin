package com.yihou.service;

import com.yihou.dao.AsmDao;
import com.yihou.model.SqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AsmService {

    @Autowired
    private AsmDao asmDao;

    public List<Map<String, Object>> findAsmInHead(Map<String, Object> params, SqlPage sqlPage) {
        return asmDao.findAsmInHead(params, sqlPage);
    }

    public List<Map<String, Object>> findAsmOutHead(Map<String, Object> params, SqlPage sqlPage) {
        return asmDao.findAsmOutHead(params, sqlPage);
    }


}
