package com.bdqn.zhang.util;

import java.util.List;

public class Page<T> {

    private Integer total;
    private Integer totalPage;
    private Integer pageSize;
    private Integer currentPage;
    private List<T> list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage() {
        this.totalPage = total%pageSize == 0 ? total/pageSize : total/pageSize + 1;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
