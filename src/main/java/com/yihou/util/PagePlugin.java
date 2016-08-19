/**
 * 版权所有：恒生电子股份有限公司 保留所有权利
 * 版本： 1.0
 * ******************************************
 * Copyright (c)  by Hundsun ,Ltd.
 * All right reserved.
 * Last version:  1.0
 */
package com.yihou.util;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yihou.model.SqlPage;
import org.apache.ibatis.binding.MapperMethod;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Properties;

/**
 * Description:
 * author yupan@18551
 * date 2016-07-12 15:39
 */
@Intercepts(@Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}))
public class PagePlugin implements Interceptor {
    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        final Object[] args = invocation.getArgs();
        Object param = args[1];
        SqlPage sqlPage = null;
        if (param instanceof SqlPage) {
            sqlPage = (SqlPage)param;
        } else if (param instanceof MapperMethod.ParamMap) {
            MapperMethod.ParamMap map = (MapperMethod.ParamMap)param;
            for (Object key : map.keySet()) {
                Object value = map.get(key);
                if(value instanceof SqlPage) {
                    sqlPage = (SqlPage) value;
                    break;
                }
            }
        }
        if (sqlPage != null && sqlPage.isPaging()) {
            if (sqlPage.isPaging() && sqlPage.isSort())//分页并排序
                PageHelper.startPage(sqlPage.getPage(), sqlPage.getRows(), sqlPage.getOrder());
            else if (sqlPage.isPaging())//只分页,不排序
                PageHelper.startPage(sqlPage.getPage(), sqlPage.getRows());
            else if (sqlPage.isSort())//只排序,不分页
                PageHelper.orderBy(sqlPage.getOrder());
        }
        if (sqlPage != null && sqlPage.isPaging()) {
            return invocation.proceed();
        } else {
            //获取原始的ms
            /*MappedStatement ms = (MappedStatement) args[0];
            String id = ms.getId();
            String className = id.substring(0,id.lastIndexOf("."));
            String methodName = id.substring(id.lastIndexOf(".") + 1, id.length());
            Method[] methods = Class.forName(className).getMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                }
            }*/
            Page page = new Page();
            Object result = invocation.proceed();
            page.addAll((List) result);
            page.setTotal(Long.valueOf(((List) result).size()));
            return page;
        }
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof Executor) {
            return Plugin.wrap(target, this);
        } else {
            return target;
        }
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
