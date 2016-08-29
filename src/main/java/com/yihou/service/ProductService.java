package com.yihou.service;

import com.yihou.dao.AsmDao;
import com.yihou.dao.ProductDao;
import com.yihou.model.SqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Map<String, Object>> findAsmInHead(Map<String, Object> params, SqlPage sqlPage) {
        return null;
    }

    public List<Map<String, Object>> findAsmOutHead(Map<String, Object> params, SqlPage sqlPage) {
        return null;
    }

    public List<Map<String, Object>> findAsmInDetail(Map<String, Object> params) {
        return null;
    }

    public List<Map<String, Object>> findAsmOutDetail(Map<String, Object> params) {
        return null;
    }

    public List<Map<String, Object>> findAsmSave(Map<String, Object> params, SqlPage sqlPage) {
        return null;
    }

}
