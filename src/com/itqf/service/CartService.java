package com.itqf.service;

import com.itqf.entity.Cart;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface CartService {
    void addCart(String pid, int uid) throws SQLException, InvocationTargetException, IllegalAccessException;

    List<Cart> findCartByUid(int uid) throws IllegalAccessException, SQLException, InvocationTargetException;
}
