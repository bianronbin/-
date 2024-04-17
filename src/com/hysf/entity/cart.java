package com.hysf.entity;

/**
 * int cart_id                     购物车中商品id
 * int product_id                  商品id
 * String product_name             商品名称
 * String product_amount           商品购买数量
 * double product_price            商品价格
 * int discounts                   判断是否有折扣（1为有，默认0）
 * double discount_price           商品折扣价格
 * int discount                    商品打几折（）
 */

public class cart {
    private int cart_id;
    private int product_id;
    private String product_name;
    private String product_amount;
    private double product_price;
    private int discounts;
    private double discount_price;
    private int discount;

    public cart() {
    }

    public cart(int cart_id, int product_id, String product_name, String product_amount, double product_price,
                int discounts, double discount_price, int discount) {
        this.cart_id = cart_id;
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_amount = product_amount;
        this.product_price = product_price;
        this.discounts = discounts;
        this.discount_price = discount_price;
        this.discount = discount;
    }

    public int getCart_id() {
        return cart_id;
    }

    public void setCart_id(int cart_id) {
        this.cart_id = cart_id;
    }

    public  int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_amount() {
        return product_amount;
    }

    public void setProduct_amount(String product_amount) {
        this.product_amount = product_amount;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public int getDiscounts() {
        return discounts;
    }

    public void setDiscounts(int discounts) {
        this.discounts = discounts;
    }

    public double getDiscount_price() {
        return discount_price;
    }

    public void setDiscount_price(double discount_price) {
        this.discount_price = discount_price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "cart{" +
                "cart_id=" + cart_id +
                ", product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", product_amount='" + product_amount + '\'' +
                ", product_price=" + product_price +
                ", discounts=" + discounts +
                ", discount_price=" + discount_price +
                ", discount=" + discount +
                '}';
    }
}
