package com.itqf.dao.impl;

import com.itqf.dao.CartDao;
import com.itqf.entity.Cart;
import com.itqf.entity.Product;
import com.itqf.utils.C3P0Utils;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CartDaoImpl implements CartDao {

    @Override
    public Cart hasProduct(int uid, String pid) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "select p.p_id as pid,p.t_id as tid,p.p_name as pname,p.p_time as ptime," +
                "p.p_image as pimage, p.p_state as pstate ,p.p_info as pinfo,p.p_price as pprice " +
                ",c.c_id as cid, c.u_id as uid,c.c_count as count,c.c_num as cnum from " +
                "product p join cart c on p.p_id = c.p_id where c.u_id = ? and c.p_id = ?;";
        Map<String, Object> result = queryRunner.query(sql, new MapHandler(), uid, pid);

        System.out.println("result = " + result);

        if (result == null) {
            return null;
        }
        Cart cart = new Cart();
        Product product = new Product();
        BeanUtils.populate(cart,result);
        BeanUtils.populate(product, result);
        cart.setProduct(product);
        return cart;
    }

    @Override
    public void insertCart(Cart cart) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "insert into cart(u_id,p_id,c_count,c_num) value(?,?,?,?)";
        BigDecimal ccount = cart.getCcount();
        queryRunner.update(sql, cart.getUid(),cart.getProduct().getPid(),ccount,cart.getCnum());
    }

    @Override
    public void updateCart(Cart cart) throws SQLException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());
        String sql = "update cart set c_num = ?,c_count = ? where c_id = ?";
        queryRunner.update(sql, cart.getCnum(),cart.getCcount(),cart.getCid());
    }

    @Override
    public List<Cart> selectCartByUid(int uid) throws SQLException, InvocationTargetException, IllegalAccessException {
        QueryRunner queryRunner = new QueryRunner(C3P0Utils.getDataSource());

        String sql = "select p.p_id as pid,p.t_id as tid,p.p_name as pname,p.p_time as ptime," +
                "p.p_image as pimage, p.p_state as pstate ,p.p_info as pinfo,p.p_price as pprice " +
                ",c.c_id as cid, c.u_id as uid,c.c_count as count,c.c_num as cnum from " +
                "product p join cart c on p.p_id = c.p_id where c.u_id = ?;";
        List<Map<String, Object>> list = queryRunner.query(sql, new MapListHandler(), uid);

        System.out.println("list = " + list);

        if (list == null && list.size() == 0) {
            return null;
        }

        List<Cart> carts = new ArrayList<>();

        for (Map<String, Object> map : list) {
            Cart cart = new Cart();
            Product product = new Product();
            BeanUtils.populate(cart,map);
            BeanUtils.populate(product, map);
            cart.setProduct(product);
            carts.add(cart);
        }

        return carts;
    }
}
