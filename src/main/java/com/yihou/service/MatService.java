package com.yihou.service;

import com.yihou.dao.MatDao;
import com.yihou.model.SqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MatService {

    @Autowired
    private MatDao matDao;

    public List<Map<String, Object>> findMatInHead(Map<String, Object> params, SqlPage sqlPage) {
        return matDao.findMatInHead(params, sqlPage);
    }

    public List<Map<String, Object>> findMatOutHead(Map<String, Object> params, SqlPage sqlPage) {
        return matDao.findMatOutHead(params, sqlPage);
    }

    public List<Map<String, Object>> findMatInDetail(Map<String, Object> params) {
        return matDao.findMatInDetail(params);
    }

    public List<Map<String, Object>> findMatOutDetail(Map<String, Object> params) {
        return matDao.findMatOutDetail(params);
    }

    public List<Map<String, Object>> findMatSave(Map<String, Object> params, SqlPage sqlPage) {
        return matDao.findMatSave(params, sqlPage);
    }

}
