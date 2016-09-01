package com.yihou.service;

import com.yihou.dao.WoDao;
import com.yihou.model.SqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WoService {

    @Autowired
    private WoDao woDao;

    public List<Map<String, Object>> findWoHead(Map<String, Object> params, SqlPage sqlPage) {
        return woDao.findWoHead(params,sqlPage);
    }

}
