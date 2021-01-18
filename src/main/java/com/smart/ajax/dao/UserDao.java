package com.smart.ajax.dao;

import com.smart.ajax.entity.SysUser;

import java.sql.SQLException;


public interface UserDao {
    SysUser selectByUsername(String username) throws SQLException;
}