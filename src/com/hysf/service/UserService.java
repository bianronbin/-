package com.hysf.service;

import com.hysf.entity.User;
import com.hysf.entity.product;

import java.util.List;

public interface UserService {

    /**
     * 注册用户
     */
    public void registerUser(User user);

    /**
     * 登录
     */
    public User login(String userName, String password);

    /**
     * 检查用户名是否可用
     */
    public boolean existsUserName(String userName);

    /**
     * 没用到
     *
     * @return
     */
    public List<product> queryProduct();

    /**
     * 商品加入到购物车
     *
     * @param product  商品信息
     * @param quantity 商品数量
     * @param userId   用户id
     */
    public void addProductToCart(product product, String quantity, long userId);
}
