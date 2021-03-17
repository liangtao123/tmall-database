package com.jack.app;
import com.jack.dao.UserDao;
import com.jack.entity.User;
import com.jack.utils.DateUtils;
import com.jack.utils.UUIDUtils;
import org.junit.Test;

import java.sql.SQLException;

/*
*
* 测试注册和登录操作
* */
public class TestUserDao {
    //创建UserDao
    UserDao userDao=new UserDao();
    //测试注册功能


    @Test
    public void  testRegister() throws SQLException {
        //1.创建User对象
        User user=new User();
        //2.对User对象进行赋值
        user.setUid(UUIDUtils.getUUID());
        user.setUsername("刘能");
        user.setPassword("123456");
        user.setTelephone("13610026359");
        user.setSex("男");
        user.setBirthday(DateUtils.getDateFormart());
        //3.执行注册
        int register = userDao.register(user);

        if(register>0){
            System.out.println("注册成功，欢迎您："+user.getUsername());
        }
        else
            System.out.println("注册失败！");

    }

    @Test
    public  void  testLogin() throws SQLException {
        //1.创建对象
        User user=userDao.login("刘能","123456");
        //2.打印信息
        if(user!=null){
            System.out.println("欢迎您! " + user.getUsername());
        }
        else
            System.out.println("登录失败！！！");

    }

}
