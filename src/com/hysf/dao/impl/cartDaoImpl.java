package com.hysf.dao.impl;

import com.hysf.dao.BaseDao;
import com.hysf.dao.cartDao;

import com.hysf.entity.cart;
import com.hysf.entity.product;

import java.util.List;

public class cartDaoImpl extends BaseDao implements cartDao {
    @Override
    public List<cart> querycart() {
        String sql = "select * from cart ";
        return queryByList(cart.class, sql);
    }

    /**
     * 查询购物车库商品id
     * @return
     */

    @Override
    public cart findProductInCartByUserIdAndProductId(Long userId, Long productId) {
        String sql = "SELECT * FROM cart WHERE user_id = ? AND product_id = ?";
        return queryByOne(cart.class, sql, userId,productId);
    }

    /**
     *
     * @param product         商品所有信息
     * @param quantity        点击收藏后，商品数量默认值1
     * @param userId          用户id
     */
    @Override
    public void addProductToCartDate(product product,String quantity,long userId) {
        String sql = "insert into cart (product_id,product_name,product_amount,product_price,discounts,discount_price," +
                "discount,user_id) values(?,?,?,?,?,?,?,?)";

        update(sql,product.getProduct_id(),product.getProduct_name(),quantity,product.getProduct_price(),
                product.getDiscounts(),product.getDiscount_price(),product.getDiscount(),userId);
    }

    @Override
    public void deleteProductFromCartDate(int product_id, long userId) {
        String sql="delete from cart where user_id = ? and product_id = ?";
        update(sql,userId,product_id);
    }

    /**
     *
     * @param product_id  商品id
     * @param quantity    文本框里的数量
     * @param userId      用户id
     */
    public void updateCard( int product_id,String quantity,long userId){
        String sql="update cart set product_amount = ? where user_id = ? and product_id = ?";
        update(sql,quantity,userId,product_id);
    }
}
