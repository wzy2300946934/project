package com.smart.ajax.service;

import com.smart.ajax.entity.Cate;

import java.sql.SQLException;
import java.util.List;


public interface CateService {
    List<Cate> list(int page, int size) throws SQLException;

    Cate findCate(int cateId);

    int add(Cate cate);

    int del(int cateId);

    int edit(Cate cate);
}
