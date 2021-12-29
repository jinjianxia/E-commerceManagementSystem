package com.dao;

import com.model.Page;
import com.model.Provider;

import java.util.List;

public interface ProviderDao {
    List<Provider> list();

    List<Provider> list(Page page);

    int delete(Provider provider);

    int getTotal();

    int addProvider(Provider provider);

    int updateProvider(Provider provider);
}
