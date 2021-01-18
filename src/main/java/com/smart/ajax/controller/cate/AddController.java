package com.smart.ajax.controller.cate;

import com.smart.ajax.service.CateService;
import com.smart.ajax.service.impl.CateSerivceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加分类信息
 */
@WebServlet("/cate/add")
public class AddController extends HttpServlet {
    private CateService cateService = new CateSerivceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
