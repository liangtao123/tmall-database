package com.jack.app;

import com.jack.dao.OrderDao;
import com.jack.entity.Order;
import com.jack.entity.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestOrderDao {
    OrderDao orderDao=new OrderDao();

    //1.获取 uid为 001 的用户的所有订单信息
    @Test
    public void testFindAllOrders() throws SQLException {
        List<Order> allOrders=orderDao.findAllOrders("001");
        for(Order orders:allOrders){

            System.out.println(orders);
        }

    }

    //2.获取所有订单号为"order001"的商品信息
    @Test
    public void testFindAllProducts()throws SQLException{
        List<Product> order001 = orderDao.findAllProducts("order001");
        for(Product product:order001){

            System.out.println(product);
        }

    }

}
