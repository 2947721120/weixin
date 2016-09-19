package com.yihou.dao;

import com.yihou.model.SqlPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MatDao {

    List<Map<String, Object>> findMatInHead(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    List<Map<String, Object>> findMatOutHead(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    List<Map<String, Object>> findMatInDetail(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findMatOutDetail(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findMatSave(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

}
