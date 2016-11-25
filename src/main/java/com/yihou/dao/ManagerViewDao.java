package com.yihou.dao;

import java.util.List;
import java.util.Map;

public interface ManagerViewDao {

    Map<String, Object> findAsmInTotal(Map<String, Object> params);

    Map<String, Object> findAsmOutTotal(Map<String, Object> params);

    Map<String, Object> findFabInTotal(Map<String, Object> params);

    Map<String, Object> findFabOutTotal(Map<String, Object> params);

    Map<String, Object> findComeQuanTotal(Map<String, Object> params);

    Map<String, Object> findReplySamTotal(Map<String, Object> params);

    Map<String, Object> findManuCountAndManuQuan(Map<String, Object> params);

    List<Map<String, Object>> findScanProcedure(Map<String, Object> params);

}
