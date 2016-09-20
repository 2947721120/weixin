package com.yihou.service;

import com.yihou.dao.DyeDao;
import com.yihou.model.SqlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by YuPan on 2016/9/21.
 */
@Service
public class DyeService {

    @Autowired
    private DyeDao dyeDao;

    public List<Map<String,Object>> findDyeMachineD(Map<String, Object> params, SqlPage sqlPage) {
        return dyeDao.findDyeMachineD(params, sqlPage);
    }

}
