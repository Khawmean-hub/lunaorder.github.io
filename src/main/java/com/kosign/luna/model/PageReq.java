package com.kosign.luna.model;

import org.springframework.data.domain.Sort;

/**
 * PageReq
 */
public class PageReq {
    private int page = 0;
    private int offset = 10;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "id";


    public PageReq() {
    }

    public PageReq(int page, int offset, Sort.Direction sortDirection, String sortBy) {
        this.page = page;
        this.offset = offset;
        this.sortDirection = sortDirection;
        this.sortBy = sortBy;
    }

    public int getPage() {
        return this.page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getOffset() {
        return this.offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public Sort.Direction getSortDirection() {
        return this.sortDirection;
    }

    public void setSortDirection(Sort.Direction sortDirection) {
        this.sortDirection = sortDirection;
    }

    public String getSortBy() {
        return this.sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public PageReq page(int page) {
        setPage(page);
        return this;
    }

    public PageReq offset(int offset) {
        setOffset(offset);
        return this;
    }

    public PageReq sortDirection(Sort.Direction sortDirection) {
        setSortDirection(sortDirection);
        return this;
    }

    public PageReq sortBy(String sortBy) {
        setSortBy(sortBy);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " page='" + getPage() + "'" +
            ", offset='" + getOffset() + "'" +
            ", sortDirection='" + getSortDirection() + "'" +
            ", sortBy='" + getSortBy() + "'" +
            "}";
    }

}