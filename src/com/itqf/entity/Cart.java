package com.itqf.entity;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 数据库对应的购物车表
 */
public class Cart implements Serializable {

    private static final long serialVersionUID = 1L;

    private int cid;
    private int uid;
    private Product product;
    private int cnum = 0;  //购车商品数量
    private BigDecimal ccount; //购物车小计

    public Cart() {
    }

    public Cart(int uid, Product product, int cnum) {
        this.uid = uid;
        this.product = product;
        this.cnum = cnum;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cid=" + cid +
                ", uid=" + uid +
                ", product=" + product +
                ", cnum=" + cnum +
                ", ccount=" + ccount +
                '}';
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getCnum() {
        return cnum;
    }

    public void setCnum(int cnum) {
        this.cnum = cnum;
    }

    public BigDecimal getCcount() {

        return product.getPprice().multiply(new BigDecimal(cnum));
    }

    public void setCcount(BigDecimal ccount) {
        this.ccount = ccount;
    }
}
