package com.yihou.dao;

import com.yihou.model.SqlPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AsmDao {

    List<Map<String, Object>> findAsmInHead(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    Map<String,Object> findTotalAsmInHead(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findAsmOutHead(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    Map<String,Object> findTotalAsmOutHead(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findAsmInDetail(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findAsmOutDetail(@Param("params") Map<String, Object> params);

    List<Map<String, Object>> findAsmSave(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

    Map<String,Object> findTotalAsmSave(@Param("params") Map<String, Object> params);

}
