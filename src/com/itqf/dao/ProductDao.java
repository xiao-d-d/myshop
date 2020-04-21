package com.itqf.dao;

import com.itqf.entity.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    long selectCount(String tid) throws SQLException;

    List<Product> selectProductByPage(String tid, int page, int pageSize) throws SQLException;

    Product selectProductById(String pid) throws SQLException;
}
