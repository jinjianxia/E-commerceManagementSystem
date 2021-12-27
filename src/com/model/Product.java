package com.model;

import java.util.Date;

public class Product {
    private Integer productId;
    private String productName;
    private Integer categoryId;
    private Integer providerId;
    private String providerName;
    private String categoryName;
    private Double purchasePrice;
    private Double salesPrice;
    private Date createdTime;
    private Integer quantity;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", categoryId=" + categoryId +
                ", providerId=" + providerId +
                ", providerName='" + providerName + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", purchasePrice=" + purchasePrice +
                ", salesPrice=" + salesPrice +
                ", createdTime=" + createdTime +
                ", quantity=" + quantity +
                '}';
    }

    public Product(String productName, Integer categoryId, Integer providerId, Double purchasePrice, Double salesPrice, Integer quantity) {
        this.productName = productName;
        this.categoryId = categoryId;
        this.providerId = providerId;
        this.purchasePrice = purchasePrice;
        this.salesPrice = salesPrice;
        this.quantity = quantity;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Product() {
    }

    public Integer getProductId() {
        return productId;
    }

    public Product setProductId(Integer productId) {
        this.productId = productId;
        return this;
    }

    public String getProductName() {
        return productName;
    }

    public Product setProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public Product setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
        return this;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public Product setProviderId(Integer providerId) {
        this.providerId = providerId;
        return this;
    }

    public Double getPurchasePrice() {
        return purchasePrice;
    }

    public Product setPurchasePrice(Double purchasePrice) {
        this.purchasePrice = purchasePrice;
        return this;
    }

    public Double getSalesPrice() {
        return salesPrice;
    }

    public Product setSalesPrice(Double salesPrice) {
        this.salesPrice = salesPrice;
        return this;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public Product setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Product setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }
}
