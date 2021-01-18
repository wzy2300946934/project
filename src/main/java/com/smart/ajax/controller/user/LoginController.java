package com.smart.ajax.controller.user;

import com.smart.ajax.entity.SysUser;
import com.smart.ajax.service.UserService;
import com.smart.ajax.service.impl.UserServiceImpl;
import com.smart.ajax.utils.ResponseEntity;
import com.smart.ajax.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/user/login")
public class LoginController extends HttpServlet {
    UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResponseEntity<SysUser> entity = null;
        try {
            entity = userService.login(username,password);
        } catch (SQLException sql) {
            entity = ResponseEntity.error();
        }
        ResponseUtils.resp(response, entity);
    }
}
