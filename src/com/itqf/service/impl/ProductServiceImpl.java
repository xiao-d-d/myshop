package com.itqf.service.impl;

import com.itqf.dao.ProductDao;
import com.itqf.dao.impl.ProductDaoImpl;
import com.itqf.entity.PageBean;
import com.itqf.entity.Product;
import com.itqf.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    @Override
    public PageBean<Product> findProductByPage(String tid, int page, int pageSize) throws SQLException {

        long totalCount = 0;
        List<Product> list = null;

        ProductDao productDao = new ProductDaoImpl();
        totalCount =  productDao.selectCount(tid);
        list= productDao.selectProductByPage(tid,page,pageSize);

        return new PageBean<Product>(pageSize,page,totalCount,list);
    }

    @Override
    public Product findProductById(String pid) throws SQLException {

        ProductDao productDao =new ProductDaoImpl();

        Product product = productDao.selectProductById(pid);

        return product;
    }
}
