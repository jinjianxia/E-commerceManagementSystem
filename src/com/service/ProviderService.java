package com.service;

import com.model.Page;
import com.model.Provider;

import java.util.List;

public interface ProviderService {
    List<Provider> list();

    List<Provider> list(Page page);
}
