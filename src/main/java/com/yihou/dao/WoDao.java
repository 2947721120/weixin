package com.yihou.dao;

import com.yihou.model.SqlPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface WoDao {

    List<Map<String, Object>> findWoHead(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    List<Map<String, Object>> findDrawFab(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

}
