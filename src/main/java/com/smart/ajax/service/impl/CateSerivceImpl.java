package com.smart.ajax.service.impl;

import com.smart.ajax.dao.CateDao;
import com.smart.ajax.dao.CateDao;
import com.smart.ajax.dao.impl.CatedaoImpl;
import com.smart.ajax.entity.Cate;
import com.smart.ajax.service.CateService;

import java.sql.SQLException;
import java.util.List;


public class CateSerivceImpl implements CateService {
    private CateDao catedao = new CatedaoImpl();

    @Override
    public List<Cate> list(int page, int size) throws SQLException {
        return  catedao.selectList((page-1)*size, size);
    }

    @Override
    public Cate findCate(int cateId) {
        return null;
    }

    @Override
    public int add(Cate cate) {
        return 0;
    }

    @Override
    public int del(int cateId) {
        return 0;
    }

    @Override
    public int edit(Cate cate) {
        return 0;
    }
}
