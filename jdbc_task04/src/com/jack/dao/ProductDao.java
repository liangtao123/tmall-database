package com.jack.dao;


import com.jack.entity.Category;
import com.jack.entity.Product;
import com.jack.utils.DruidUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    //需求1: 根据商品ID 获取商品名称 ,商品价格 以及商品所属分类的名称
    //参数 pid, 返回值 product对象

    public Product findById(String pid) throws SQLException {
        //1.获取对象
        QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
        //2.sql语句
        String sql="select * from product where pid =?";
        //3.执行sql语句
        Product product = qr.query(sql, new BeanHandler<Product>(Product.class), pid);
        //外键cid
        String cid=product.getCid();
        //4.根据cid,调用findCategoryById找到商品分类的信息
        Category category=findCategoryById(cid);
        product.setCategory(category);
        return  product;
    }

    //需求2: 根据分类ID 获取商品分类信息
    //参数 cid , 返回值 category对象
    public Category findCategoryById(String cid) throws SQLException {
        //1.创建QueryRunner对象
        QueryRunner qr=new QueryRunner(DruidUtils.getDataSource());
        //2，编写sql语句
        String sql="select * from category where cid=?";

        //3.执行查询
        Category category=qr.query(sql,new BeanHandler<Category>(Category.class),cid);

        return category;

    }

   //需求3： 查询指定分类ID 下的商品个数
    //参数:String cid 返回值 count (int)
    public  int getCount(String cid) throws SQLException {
        QueryRunner qr= new QueryRunner(DruidUtils.getDataSource());
        String sql="select count(*) from product where cid=? ";

        Long count=qr.query(sql,new ScalarHandler<>(),cid);
        return count.intValue();
    }

    //4.查询指定分类下的所有商品信息
    public List<Product> findProductByCid(String cid) throws SQLException {
        QueryRunner qr= new QueryRunner(DruidUtils.getDataSource());
        String sql="select * from product where cid=?";

        //查询结果是一个list集合，使用BeanListHandler来封装
        List <Product> products=qr.query(sql,new BeanListHandler<Product>(Product.class),cid);

        return  products;
    }
}
