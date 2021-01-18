package com.smart.ajax.dao.impl;

import com.smart.ajax.dao.UserDao;
import com.smart.ajax.entity.SysUser;
import com.smart.ajax.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDaoImpl implements UserDao {

    @Override
    public SysUser selectByUsername(String username) throws SQLException {
        SysUser sysUser = null;
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet resultSet=null;

        try{connection = DbManager.getConnection();
            String sql = "select uid,username,password,status from sys_user where username=?";
            ps = connection.prepareStatement(sql);
            ps.setString(1,username);
            resultSet = ps.executeQuery();

            while (resultSet.next()){
                int uid = resultSet.getInt(1);
                String user_name = resultSet.getString(2);
                String pass_word = resultSet.getString(3);
                int status = resultSet.getInt(4);
                sysUser = new SysUser(uid,user_name,pass_word,status);
            }
        }finally {
            DbManager.close(resultSet,connection,ps);
        }

        return sysUser;
    }
}
