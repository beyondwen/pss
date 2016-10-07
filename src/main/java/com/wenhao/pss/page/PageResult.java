package com.wenhao.pss.page;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/10/07.
 */
public class PageResult<T> {
    private int currentPage;//当前页
    private int pageSize;//每页多少条
    private int totalCount;//总条数
    private int totalPage;//总共多少页
    private List<T> rowList = new ArrayList<T>();//每页的数据


    public PageResult() {
    }

    public PageResult(int currentPage, int pageSize, int totalCount) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPage = (this.getTotalCount() + this.getPageSize() - 1) / this.getPageSize();
        this.currentPage = this.currentPage > this.getTotalPage() ? this.totalPage : this.currentPage;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getRowList() {
        return rowList;
    }

    public void setRowList(List<T> rowList) {
        this.rowList = rowList;
    }

    @Override
    public String toString() {
        return "PageResult{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", rowList.size=" + rowList.size() +
                '}';
    }
}