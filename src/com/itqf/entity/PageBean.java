package com.itqf.entity;

import java.util.List;

public class PageBean<T> {

    private int pageSize;
    private int currentPage;
    private long totalCount; //总条数
    private int  pageCount; //总页数
    private List<T> list; //数据

    public PageBean(int pageSize, int currentPage, long totalCount, List<T> list) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.list = list;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageCount() {
        return (int) Math.ceil(totalCount*1.0/pageSize);
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
