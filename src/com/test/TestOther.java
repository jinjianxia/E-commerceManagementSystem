package com.test;

import com.model.Provider;
import com.service.ProviderService;
import com.service.impl.ProviderServiceImpl;

import java.util.List;

public class TestOther {
    public static void main(String[] args) {
        ProviderService providerService = new ProviderServiceImpl();
        List<Provider> providerList = providerService.list();
        for (Provider provider : providerList) {
            System.out.println(provider.getProviderName());
        }
    }
}
