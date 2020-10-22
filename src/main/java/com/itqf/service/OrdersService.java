package com.itqf.service;

import com.itqf.entity.Orders;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface OrdersService {
    void createOrder(String aid, String uid, String sum) throws IllegalAccessException, SQLException, InvocationTargetException;

    List<Orders> findOrdersByUid(int uid) throws IllegalAccessException, SQLException, InvocationTargetException;

    Orders findOrderByOid(String oid) throws IllegalAccessException, SQLException, InvocationTargetException;

    void updateStateByOid(String oid) throws SQLException;
}
