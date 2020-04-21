package com.itqf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 对应数据库的订单表
 */
public class Orders implements Serializable {

    private static  final long serialVersionUID = 1L;

    private String oid;
    private int uid;
    private BigDecimal ocount; //订单总金额
    private Date otime;
    private int ostate; //订单状态 0 未付款，1已经付款未发货 2发货待收货 3 收货待评价 4订单完成 5 退货状态

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public BigDecimal getOcount() {
        return ocount;
    }

    public void setOcount(BigDecimal ocount) {
        this.ocount = ocount;
    }

    public Date getOtime() {
        return otime;
    }

    public void setOtime(Date otime) {
        this.otime = otime;
    }

    public int getOstate() {
        return ostate;
    }

    public void setOstate(int ostate) {
        this.ostate = ostate;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "oid='" + oid + '\'' +
                ", uid=" + uid +
                ", ocount=" + ocount +
                ", otime=" + otime +
                ", ostate=" + ostate +
                '}';
    }
}
