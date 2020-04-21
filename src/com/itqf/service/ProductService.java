package com.itqf.service;

import com.itqf.entity.PageBean;
import com.itqf.entity.Product;

import java.sql.SQLException;

public interface ProductService {
    PageBean<Product> findProductByPage(String tid, int page, int pageSize) throws SQLException;

    Product findProductById(String pid) throws SQLException;
}
