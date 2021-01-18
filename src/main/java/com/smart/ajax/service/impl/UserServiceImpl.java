package com.smart.ajax.service.impl;

import com.smart.ajax.dao.UserDao;
import com.smart.ajax.dao.impl.UserDaoImpl;
import com.smart.ajax.entity.SysUser;
import com.smart.ajax.service.UserService;
import com.smart.ajax.utils.ResponseCode;
import com.smart.ajax.utils.ResponseEntity;
import com.smart.ajax.utils.ResponseUtils;

import java.sql.SQLException;


public class UserServiceImpl  implements UserService {
    UserDao userDao = new UserDaoImpl();
    @Override
    public ResponseEntity<SysUser> login(String username, String password) throws SQLException {
        ResponseEntity<SysUser> responseEntity = null;
        SysUser sysUser = userDao.selectByUsername(username);
        if (sysUser!=null){
            if (sysUser.getStatus()==1){
                if (sysUser.getPassword().equals(password)){
                    responseEntity = ResponseEntity.success(sysUser);
                }else {
                    responseEntity = ResponseEntity.error(ResponseCode.USER_LOGIN_ERROR);
                }
            }else {
                responseEntity  =ResponseEntity.error(400002,"该用户被锁定，请于江帅联系");
            }
        }else {
            responseEntity = ResponseEntity.error(400003, "用户名不存在");
        }
        return null;
    }
}
