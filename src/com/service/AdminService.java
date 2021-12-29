package com.service;

import com.model.Admin;

public interface AdminService {
    int register(Admin admin);

    boolean login(Admin admin);

    boolean checkDuplicateName(Admin admin);
}
