package com.smart.ajax.dao;

import com.smart.ajax.entity.Cate;

import java.sql.SQLException;
import java.util.List;

public interface CateDao {
    List<Cate> selectList(int limit, int offset) throws SQLException;
}
