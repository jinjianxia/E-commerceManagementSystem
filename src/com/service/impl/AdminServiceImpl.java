package com.service.impl;

import com.dao.AdminDao;
import com.dao.impl.AdminDaoImpl;
import com.model.Admin;
import com.service.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = new AdminDaoImpl();

    @Override
    public int register(Admin admin) {
        return adminDao.register(admin);
    }

    @Override
    public boolean login(Admin admin) {
        return adminDao.login(admin);
    }

    @Override
    public boolean checkDuplicateName(Admin admin) {
        return adminDao.checkDuplicateName(admin);
    }
}
