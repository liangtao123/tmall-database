package com.jack.dao;

import com.jack.entity.Order;
import com.jack.entity.OrderItem;
import com.jack.entity.Product;
import com.jack.utils.DruidUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    //需求1：获取uid为001的用户的所有订单信息
    //参数:uid 返回值List<Orders>

    public List<Order> findAllOrders(String uid) throws SQLException {
        QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());

        String sql="select * from orders where uid=?";

        List<Order> orders = qr.query(sql, new BeanListHandler<Order>(Order.class), uid);
        return  orders;

    }
    //需求2:获取订单编号为order001的订单中的所有商品信息
    //参数oid,返回值List<Product>商品集合
    public List<Product> findAllProducts(String oid) throws SQLException {
        QueryRunner qr = new QueryRunner(DruidUtils.getDataSource());

        //1.查询订单项表 获取订单项表中 订单ID为order001的数据
        String sql = "SELECT pid FROM orderitem WHERE oid = ? ";

        //2.查询的结果是 多条订单项数据
        List<OrderItem> list = qr.query(sql, new BeanListHandler<OrderItem>(OrderItem.class), oid);

        //3.创建集合保存商品信息
        List<Product> productList = new ArrayList<>();

        ProductDao productDao = new ProductDao();

        //4.遍历订单项集合 获取Pid
        for (OrderItem orderItem : list) {

            //4.1从orderitem中获取 pid
            String pid = orderItem.getPid();

            //4.2 调用productDao
            Product product =  productDao.findById(pid);

            //4.3 保存到集合
            productList.add(product);
        }

        //返回 订单中对应的商品信息
        return productList;
    }

}
