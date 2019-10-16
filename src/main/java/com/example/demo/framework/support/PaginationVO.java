package com.example.demo.framework.support;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/12 14:08
 */
public class PaginationVO {

    private long page;

    private long pageSize;

    public long getPage() {
        if (page == 0)
            return 1;
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getPageSize() {
        if (pageSize == 0)
            return 10;
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }
}