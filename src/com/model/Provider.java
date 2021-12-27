package com.model;

public class Provider {
    private Integer providerId;
    private String providerName;
    private String providerTel;
    private String providerAccount;
    private String providerEmail;

    public Integer getProviderId() {
        return providerId;
    }

    public Provider setProviderId(Integer providerId) {
        this.providerId = providerId;
        return this;
    }

    public String getProviderName() {
        return providerName;
    }

    public Provider setProviderName(String providerName) {
        this.providerName = providerName;
        return this;
    }

    public String getProviderTel() {
        return providerTel;
    }

    public Provider setProviderTel(String providerTel) {
        this.providerTel = providerTel;
        return this;
    }

    public String getProviderAccount() {
        return providerAccount;
    }

    public Provider setProviderAccount(String providerAccount) {
        this.providerAccount = providerAccount;
        return this;
    }

    public String getProviderEmail() {
        return providerEmail;
    }

    public Provider setProviderEmail(String providerEmail) {
        this.providerEmail = providerEmail;
        return this;
    }
}
