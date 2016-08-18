package com.yihou.dao;

import java.util.Map;

public interface UserDao {
    Map<String,Object> findOne(Map<String,Object> params);
}
