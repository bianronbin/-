package com.hysf.service.impl;

import com.hysf.dao.BaseDao;
import com.hysf.dao.UserDao;
import com.hysf.dao.cartDao;
import com.hysf.dao.impl.UserDaoImpl;
import com.hysf.Permission.Permission;
import com.hysf.dao.impl.cartDaoImpl;
import com.hysf.entity.User;
import com.hysf.entity.cart;
import com.hysf.entity.product;
import com.hysf.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();
    private cartDao cartDao = new cartDaoImpl();


    @Override
    public void registerUser(User user) {
        // java8新特性
        // User userEntity = Optional.ofNullable(user).orElse(new User());
        if (user.getUsername() == null || user.getPassword() == null) {
            System.out.println("用户名或密码不能为空");
            System.out.println("或者没有获取到用户名和密码");
        }
        if (user.getUsername().length() < 4) {
            System.out.println("用户名不合法");
        }
        if (user.getPassword().length() < 4) {
            System.out.println("密码不合法");
        }

        System.out.println(user);
        userDao.saveUser(user);
        List<Permission> permissions = Arrays.asList(
                Permission.VIEW_PRODUCT,
                Permission.ADD_TO_CART,
                Permission.MODIFY_PURCHASE_QUANTITY,
                Permission.MODIFY_PERSONAL_INFO
        );
        //获取到刚注册的user并赋权
        userDao.addUserPermissions(BaseDao.getLastInsertId(), permissions);
    }

    @Override
    public User login(String userName, String password) {
        if (userName == null || password == null) {
            System.out.println("用户名或密码不能为空");
            System.out.println("或者没有获取到用户名和密码");
        }
        return userDao.queryUserByUsernameAndPassword(userName, password);
    }

    @Override
    public boolean existsUserName(String userName) {
        if (userDao.queryUserByUsername(userName) == null) {
            // 等于null 说明没有查到，没有查到表示用户名可用
            return false;
        }
        // 查到 说明不可用
        return true;
    }

    @Override
    public List<product> queryProduct() {
        return userDao.queryProduct();
    }


    @Override
    public void addProductToCart(product product, String quantity, long userId) {
        cart existingCart = cartDao.findProductInCartByUserIdAndProductId(userId, (long) product.getProduct_id());
        if (existingCart == null) {
            // 如果商品不存在，新增商品
            cartDao.addProductToCartDate(product, quantity, userId);
        } else {
            //如果商品在购物车中已存在则数量加1
            int quantity1 = Integer.parseInt(quantity);
            quantity1 = quantity1 + 1;
            String newQuantity = Integer.toString(quantity1);
            cartDao.updateCard(product.getProduct_id(), newQuantity, userId);
        }

    }
}
