package com.yihou.service;

import com.yihou.dao.FabDao;
import com.yihou.model.SqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class FabService {

    @Autowired
    private FabDao fabDao;

    public List<Map<String, Object>> findFabInHead(Map<String, Object> params, SqlPage sqlPage) {
        return fabDao.findFabInHead(params, sqlPage);
    }

    public List<Map<String, Object>> findFabOutHead(Map<String, Object> params, SqlPage sqlPage) {
        return fabDao.findFabOutHead(params,sqlPage);
    }

    public List<Map<String, Object>> findFabInDetail(Map<String, Object> params) {
        return fabDao.findFabInDetail(params);
    }

    public List<Map<String, Object>> findFabOutDetail(Map<String, Object> params) {
        return fabDao.findFabOutDetail(params);
    }

    public List<Map<String, Object>> findFabSave(Map<String, Object> params, SqlPage sqlPage) {
        return fabDao.findFabSave(params, sqlPage);
    }

}
