package com.yihou.service;

import com.yihou.dao.AsmInDao;
import com.yihou.model.SqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AsmInService {

    @Autowired
    private AsmInDao asmInDao;

    public List<Map<String, Object>> findAsmInHead(Map<String, Object> params, SqlPage sqlPage) {
        return asmInDao.findAsmInHead(params, sqlPage);
    }


}
