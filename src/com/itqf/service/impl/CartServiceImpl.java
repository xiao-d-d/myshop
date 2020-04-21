package com.itqf.service.impl;

import com.itqf.dao.CartDao;
import com.itqf.dao.ProductDao;
import com.itqf.dao.impl.CartDaoImpl;
import com.itqf.dao.impl.ProductDaoImpl;
import com.itqf.entity.Cart;
import com.itqf.entity.Product;
import com.itqf.service.CartService;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public class CartServiceImpl implements CartService {

    @Override
    public void addCart(String pid, int uid) throws SQLException, InvocationTargetException, IllegalAccessException {

        CartDao cartDao = new CartDaoImpl();

        //1.判断是否存在商品
        Cart cart = cartDao.hasProduct(uid,pid);

        if (cart == null) {
            //2.不存在添加
            ProductDao productDao = new ProductDaoImpl();
            Product product = productDao.selectProductById(pid);
            cart = new Cart(uid,product,1);
            cartDao.insertCart(cart);
        }else{
            //3.存在修改数量和小计
            cart.setCnum(cart.getCnum()+1);
            cartDao.updateCart(cart);
        }
    }

    @Override
    public List<Cart> findCartByUid(int uid) throws IllegalAccessException, SQLException, InvocationTargetException {
        CartDao cartDao = new CartDaoImpl();
        List<Cart> list = cartDao.selectCartByUid(uid);
        return list;
    }
}
