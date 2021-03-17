package com.jack.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *   订单表
 *   `oid` VARCHAR(32) NOT NULL,
 *   `ordertime` DATETIME DEFAULT NULL,
 *   `total` DOUBLE DEFAULT NULL,
 *   `name` VARCHAR(20) DEFAULT NULL,
 *   `telephone` VARCHAR(20) DEFAULT NULL,
 *   `address` VARCHAR(30) DEFAULT NULL,
 *   `state` INT(11) DEFAULT NULL,
 *   `uid` VARCHAR(32) DEFAULT NULL,
 *
 * */
public class Order {
    private String oid;
    private String ordertime;
    private double total;
    private String name;
    private String telephone;
    private String address;
    private int state;
    private String uid;//外键
    private User user;

    //描述 多对一关系 一个订单中 包含了多个订单项信息
    List<OrderItem> list = new ArrayList<>();

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Order{" +
                "oid='" + oid + '\'' +
                ", ordertime='" + ordertime + '\'' +
                ", total=" + total +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", address='" + address + '\'' +
                ", state=" + state +
                ", uid='" + uid + '\'' +
                '}';
    }
}
