package com.service;

import com.dao.ProviderDao;
import com.dao.ProviderDapImpl;
import com.model.Page;
import com.model.Provider;

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
}
