package com.yihou.model;

import com.github.pagehelper.PageHelper;

import java.io.Serializable;

/**
 * SQL查询语句分页辅助类
 */
public class SqlPage implements Serializable {

    private static final long serialVersionUID = -6469724259475556142L;
    /**
     * 当前页
     */
    private int page;
    /**
     * 每页显示记录数
     */
    private int rows;
    /**
     * 开始条数
     */
    private int offset;
    /**
     * 结束条数
     */
    private int limit;
    /**
     * asc/desc 默认desc
     */
    private String order;

    public SqlPage() {
        super();
    }

    public SqlPage(int page, int rows) {
        super();
        this.page = page;
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public boolean isPaging() {
        return this.page > 0 || this.limit > 0;
    }

    public boolean isSort() {
        return !(this.order == null || "".equals(this.order));
    }

    /**
     * 根据page和rows设置分页或排序
     *
     * @param sortOrder 排序规则
     */
    public void pagingOrSort(String sortOrder) {
        if (this.isPaging() && this.isSort())//分页并排序
            PageHelper.startPage(this.getPage(), this.getRows(), sortOrder);
        else if (this.isPaging())//只分页,不排序
            PageHelper.startPage(this.getPage(), this.getRows());
        else if (this.isSort())//只排序,不分页
            PageHelper.orderBy(sortOrder);
    }

}
