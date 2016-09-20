package com.yihou.dao;

import com.yihou.model.SqlPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface DyeDao {

    List<Map<String, Object>> findDyeMachineD(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

}
