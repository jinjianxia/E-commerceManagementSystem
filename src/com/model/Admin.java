package com.model;

import java.util.Date;

public class Admin {
    private Integer adminId;
    private String adminName;
    private String adminPassword;
    private Date date;

    public Integer getAdminId() {
        return adminId;
    }

    public Admin setAdminId(Integer adminId) {
        this.adminId = adminId;
        return this;
    }

    public String getAdminName() {
        return adminName;
    }

    public Admin setAdminName(String adminName) {
        this.adminName = adminName;
        return this;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public Admin setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Admin setDate(Date date) {
        this.date = date;
        return this;
    }

    public Admin(String adminName, String adminPassword) {
        this.adminName = adminName;
        this.adminPassword = adminPassword;
    }
}
