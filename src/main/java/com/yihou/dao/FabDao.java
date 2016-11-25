package com.yihou.dao;

import com.yihou.model.SqlPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FabDao {

    List<Map<String, Object>> findFabInHead(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    Map<String,Object> findTotalFabInHead(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findFabInDetail(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findFabOutHead(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    Map<String,Object> findTotalFabOutHead(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findFabOutDetail(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findFabSave(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    Map<String,Object> findTotalFabSave(@Param("params") Map<String, Object> params);

}
