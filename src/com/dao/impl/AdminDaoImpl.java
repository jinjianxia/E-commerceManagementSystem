package com.dao.impl;

import com.dao.AdminDao;
import com.model.Admin;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.util.Date;

public class AdminDaoImpl implements AdminDao {
    DBUtil dbUtil = new DBUtil();

    @Override
    public int register(Admin admin) {
        int result = 0;
        String sql = "insert into admin (admin_name,admin_password,date) value(?,?,?)";
        Object[] objects = {admin.getAdminName(), admin.getAdminPassword(), new Date()};
        try {
            result = dbUtil.executeUpdate(sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return result;
    }

    @Override
    public boolean login(Admin admin) {
        boolean result = false;
        String sql = "select * from admin where admin_name=?and admin_password=?";
        Object[] objects = {admin.getAdminName(), admin.getAdminPassword()};
        try {
            ResultSet rs = dbUtil.executeQuery(sql, objects);
            while (rs.next()) {
                result = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return result;
    }
}
