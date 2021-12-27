package com.dao.impl;

import com.dao.ProviderDao;
import com.model.Provider;

import java.util.List;

import com.model.Page;
import com.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class ProviderDapImpl implements ProviderDao {
    private final DBUtil dbUtil = new DBUtil();

    @Override
    public List<Provider> list() {
        String sql = "select * from providers";
        Object[] objects = {};
        return getProvider(sql, objects);
    }

    @Override
    public List<Provider> list(Page page) {
        String sql = "select * from providers limit ?,?";
        Object[] objects = {(page.getPageNum() - 1) * page.getSize(), page.getSize()};
        return getProvider(sql, objects);
    }

    private List<Provider> getProvider(String sql, Object[] objects) {
        List<Provider> providers = new ArrayList<>();
        try {
            ResultSet rs = dbUtil.executeQuery(sql, objects);
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setProviderId(rs.getInt("provider_id"));
                provider.setProviderName(rs.getString("provider_name"));
                provider.setProviderTel(rs.getString("provider_tel"));
                provider.setProviderAccount(rs.getString("account"));
                provider.setProviderEmail(rs.getString("email"));
                providers.add(provider);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return providers;
    }
}
