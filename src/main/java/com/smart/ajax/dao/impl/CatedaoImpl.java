package com.smart.ajax.dao.impl;

import com.smart.ajax.dao.CateDao;
import com.smart.ajax.dao.CateDao;
import com.smart.ajax.entity.Cate;
import com.smart.ajax.utils.DbManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class CatedaoImpl implements CateDao {
    @Override
    public List<Cate> selectList(int limit, int offset) throws SQLException {
        List<Cate> cates = new ArrayList<>();
        Connection connection = null;
        ResultSet resultSet = null;
        PreparedStatement ps = null;

        try {
            connection = DbManager.getConnection();
            //分页查询
            String sql = "select cate_id,name,code,version,remark,is_del from cate limit ?, ?";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, limit);
            ps.setInt(2, offset);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Cate cate = new Cate();
                cate.setCateId(resultSet.getInt(1));
                cate.setName(resultSet.getString(2));
                cate.setCode(resultSet.getString(3));
                cate.setVersion(resultSet.getInt(4));
                cate.setRemark(resultSet.getString(5));
                cate.setIsDel(resultSet .getInt(6));

                cates.add(cate);
            }
        } finally {
            DbManager.close(resultSet, connection, ps);
        }
        return cates;
    }
}
