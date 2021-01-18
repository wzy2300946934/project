package com.smart.ajax.controller.cate;

import com.smart.ajax.entity.Cate;
import com.smart.ajax.service.CateService;
import com.smart.ajax.service.impl.CateSerivceImpl;
import com.smart.ajax.utils.ResponseEntity;
import com.smart.ajax.utils.ResponseUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * http://127.0.0.1:8080/cate/list?page=1&size=10
 */
@WebServlet("/cate/list")
public class ListController extends HttpServlet {
    //实例化CateServiceImpl对象并转换成CateService类型
    private CateService cateService = new CateSerivceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        int page = Integer.parseInt(req.getParameter("page"));
        int size = Integer.parseInt(req.getParameter("size"));

        ResponseEntity<List<Cate>> entity;
        try {
            List<Cate> list = cateService.list(page, size);
            entity = ResponseEntity.success(list);
        } catch (SQLException throwables) {
            entity = ResponseEntity.error();
        }
        ResponseUtils.resp(resp, entity);
    }
}
