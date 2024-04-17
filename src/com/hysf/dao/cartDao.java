package com.hysf.dao;

import com.hysf.entity.cart;
import com.hysf.entity.product;

import java.util.List;
import java.util.Optional;

public interface cartDao {
    //查询购物清单
    public List<cart> querycart();
    cart findProductInCartByUserIdAndProductId(Long userId, Long productId);

    public void updateCard(int product_id,String quantity,long userId);
    //增加商品到购物车中
    public void addProductToCartDate(product product,String quantity,long userId);
    public void deleteProductFromCartDate(int product_id,long userId);

}
