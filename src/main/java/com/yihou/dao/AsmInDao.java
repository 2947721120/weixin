package com.yihou.dao;

import com.yihou.model.SqlPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AsmInDao {

    List<Map<String, Object>> findAsmInHead(@Param("params") Map<String, Object> params, @Param("sqlPage") SqlPage sqlPage);

}
