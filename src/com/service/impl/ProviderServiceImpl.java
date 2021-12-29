package com.service.impl;

import com.dao.ProviderDao;
import com.dao.impl.ProviderDapImpl;
import com.model.Page;
import com.model.Provider;
import com.service.ProviderService;

import java.util.List;

public class ProviderServiceImpl implements ProviderService {
    ProviderDao providerDao = new ProviderDapImpl();

    @Override
    public List<Provider> list() {
        return providerDao.list();
    }

    @Override
    public List<Provider> list(Page page) {
        return providerDao.list(page);
    }

    @Override
    public int delete(Provider provider) {
        return providerDao.delete(provider);
    }

    @Override
    public int getTotal() {
        return providerDao.getTotal();
    }

    @Override
    public int addProvider(Provider provider) {
        return providerDao.addProvider(provider);
    }

    @Override
    public int updateProvider(Provider provider) {
        return providerDao.updateProvider(provider);
    }
}
