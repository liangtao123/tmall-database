package com.jack.entity;

import com.sun.nio.sctp.AbstractNotificationHandler;

/**
 *   订单项表(中间表)
 *   `itemid` VARCHAR(32) NOT NULL,
 *   `pid` VARCHAR(32) DEFAULT NULL,
 *   `oid` VARCHAR(32) DEFAULT NULL,
 *
 * */
public class OrderItem {
    private  String itemid;
    private String  pid;//中间表外键 指向product主键
    private String oid;//中间表外键，指向orders主键

    private Product product;
    private Order Order;

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public com.jack.entity.Order getOrder() {
        return Order;
    }

    public void setOrder(com.jack.entity.Order order) {
        Order = order;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "itemid='" + itemid + '\'' +
                ", pid='" + pid + '\'' +
                ", oid='" + oid + '\'' +
                '}';
    }
}
