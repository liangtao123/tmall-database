package com.jack.app;

import com.jack.dao.ProductDao;
import com.jack.entity.Category;
import com.jack.entity.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

public class TestProductDao {
    /*
    * 测试Product的四个需求的测试类
    * */
    //创建ProductDao对象
    ProductDao productDao=new ProductDao();

    //1.测试,根据商品ID,获取商品信息，商品价格，以及商品所属分类的名称
    @Test
    public void testFindById() throws SQLException {
        //调用findById方法
        Product product=productDao.findById("2");
        //打印信息
        System.out.println("商品名称:"+product.getPname() +"\n商品价格:"
                +product.getPrice()+"\n商品所属分类的名称:"+product.getCategory().getCname());

    }

    //测试findCategoryById 方法
    @Test
    public void  testFindCategoryById() throws SQLException {
        //调用findCategoryById
        Category category=productDao.findCategoryById("2");
        System.out.println("cid为2的商品分类是:"+category.getCname());
    }


    //测试需求3
    //需求3： 查询指定分类ID 下的商品个数
    //参数:String cid 返回值 count (int)
    @Test
    public void testGetCount() throws SQLException {
    int count=productDao.getCount("3");
    System.out.println("cid为3的商品个数:"+count);

    }

    //4.查询指定分类下的所有商品信息
    @Test
    public void testFindProductByCid() throws SQLException {
        List<Product> products=productDao.findProductByCid("2");
        for(Product product:products){
            System.out.println(product);
        }
    }

}
