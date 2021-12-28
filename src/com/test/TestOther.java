package com.test;

import com.dao.AdminDao;
import com.dao.ProviderDao;
import com.dao.impl.AdminDaoImpl;
import com.dao.impl.ProviderDapImpl;
import com.model.Admin;
import com.model.Page;
import com.model.Provider;

import java.util.List;

public class TestOther {
    public static void main(String[] args) {
//        CategoryDao categoryDao = new CategoryDaoImpl();
//        List<Category> categories = categoryDao.list();
//        System.out.println(categories);
//        for (Category category : categories) {
//            System.out.println(category.getCategoryName());
//        }
//        ProviderDao providerDao = new ProviderDapImpl();
//        List<Provider> providers = providerDao.list(new Page(1,2));
//        for (Provider provider : providers) {
//            System.out.println(provider.getProviderName());
//        }
        AdminDao adminDao = new AdminDaoImpl();
//        System.out.println(adminDao.register(new Admin("name", "password")));
        System.out.println(adminDao.login(new Admin("name","password")));
    }
}
