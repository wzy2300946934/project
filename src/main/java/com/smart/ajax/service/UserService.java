package com.smart.ajax.service;

import com.smart.ajax.entity.SysUser;
import com.smart.ajax.utils.ResponseEntity;

import java.sql.SQLException;


public interface UserService {
    ResponseEntity<SysUser> login(String username, String password) throws SQLException;
}
