package com.hysf.test;

import com.hysf.dao.BaseDao;

import com.hysf.dao.impl.UserDaoImpl;
import com.hysf.entity.product;
import org.junit.Test;


public class test {
    private BaseDao userDao = new UserDaoImpl();

    @Test
    public void test1() {
        String sql = "select * from product ";
        System.out.println(userDao.queryByList(product.class, sql));
    }
    @Test
    public void test2() {
        String sql = "delete from cart  where user_id = ? and product_id = ?";
        userDao.update(sql,2,42);
        String sql1 = "select * from cart ";
        System.out.println(userDao.queryByList(product.class, sql1));
    }
}
