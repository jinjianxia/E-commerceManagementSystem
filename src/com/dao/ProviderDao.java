package com.dao;

import com.model.Page;
import com.model.Provider;

import java.util.List;

public interface ProviderDao {
    List<Provider> list();

    List<Provider> list(Page page);
}
