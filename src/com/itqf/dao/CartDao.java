package com.itqf.dao;

import com.itqf.entity.Cart;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface CartDao {
    Cart hasProduct(int uid, String pid) throws SQLException, InvocationTargetException, IllegalAccessException;

    void insertCart(Cart cart) throws SQLException;

    void updateCart(Cart cart) throws SQLException;

    List<Cart> selectCartByUid(int uid) throws SQLException, InvocationTargetException, IllegalAccessException;
}
