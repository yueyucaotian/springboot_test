package com.example.demo.vo;

/**
 * @author Cao
 * @version 1.0
 * @date 2019/10/17 17:30
 */
public class PaginationVO {

    private long page;

    private long limit;

    public long getPage() {
        if (page == 0)
            return 1;
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public long getLimit() {
        return limit;
    }

    public void setLimit(long limit) {
        this.limit = limit;
    }
}
