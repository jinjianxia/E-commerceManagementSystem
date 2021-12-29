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

    @Override
    public int delete(Provider provider) {
        int result = 0;
        String sql = "delete from providers where provider_id=?";
        Object[] objects = {provider.getProviderId()};
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
    public int getTotal() {
        int total = 0;
        String sql = "select count(*) as total from providers";
        Object[] objects = {};
        ResultSet rs = dbUtil.executeQuery(sql, objects);
        try {
            rs.next();
            total = rs.getInt("total");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return total;
    }

    @Override
    public int addProvider(Provider provider) {
        int result = 0;
        String sql = "insert into providers (provider_name,provider_address,provider_tel,account,email) values (?,?,?,?,?)";
        Object[] objects = {provider.getProviderName(), provider.getProviderAddress(), provider.getProviderTel(), provider.getProviderAccount(), provider.getProviderEmail()};
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
    public int updateProvider(Provider provider) {
        int result = 0;
        String sql = "update providers set provider_name = ?, provider_address = ? ,provider_tel = ?, account = ? ,email = ? where provider_id = ?";
        Object[] objects = {provider.getProviderName(), provider.getProviderAddress(), provider.getProviderTel(), provider.getProviderAccount(), provider.getProviderEmail(), provider.getProviderId()};
        try {
            result = dbUtil.executeUpdate(sql, objects);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeAll();
        }
        return result;
    }

    private List<Provider> getProvider(String sql, Object[] objects) {
        List<Provider> providers = new ArrayList<>();
        try {
            ResultSet rs = dbUtil.executeQuery(sql, objects);
            while (rs.next()) {
                Provider provider = new Provider();
                provider.setProviderId(rs.getInt("provider_id"));
                provider.setProviderName(rs.getString("provider_name"));
                provider.setProviderAddress(rs.getString("provider_address"));
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
