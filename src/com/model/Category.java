package com.model;

public class Category {
    private Integer categoryId;
    private String categoryName;

    public Category() {
    }

    public Category(String categoryName, String categoryDesc) {
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Category setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public Category setCategoryName(String categoryName) {
        this.categoryName = categoryName;
        return this;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public Category setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
        return this;
    }

    private String categoryDesc;
}
