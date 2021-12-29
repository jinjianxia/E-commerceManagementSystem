package com.dao;

import com.model.Admin;

public interface AdminDao {
    int register(Admin admin);

    boolean login(Admin admin);

    boolean checkDuplicateName(Admin admin);
}
