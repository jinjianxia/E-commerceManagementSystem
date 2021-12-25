package com.model;

public class Page {
    private Integer pageNum;
    private Integer size;

    public Integer getPageNum() {
        return pageNum;
    }

    public Page setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
        return this;
    }

    public Integer getSize() {
        return size;
    }

    public Page setSize(Integer size) {
        this.size = size;
        return this;
    }

    public Page() {
    }

    public Page(Integer pageNum, Integer size) {
        this.pageNum = pageNum;
        this.size = size;
    }
}
