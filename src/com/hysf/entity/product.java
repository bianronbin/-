package com.hysf.entity;

/**
 * int product_id                 商品id
 * String product_name            商品名称
 * String imagine                 商品图片地址
 * int parent_id                  属于的2级标签id
 * int category_id                属于的1级标签id
 * double product_price           商品价格
 * String seller_name             卖家用户名
 * int discounts                  判断是否有折扣（1有，默认0）
 * double discount_price          商品折扣价
 * int discount                   打几折
 */

public class product {
    private int product_id;
    private String product_name;
    private String imagine;
    private int parent_id;
    private int category_id;
    private double product_price;
    private String seller_name;
    private int discounts;
    private double discount_price;
    private int discount;

    public product() {
    }

    public product(int product_id, String product_name, String imagine, int parent_id, int category_id,
                   double product_price, String seller_name, int discounts, double discount_price, int discount) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.imagine = imagine;
        this.parent_id = parent_id;
        this.category_id = category_id;
        this.product_price = product_price;
        this.seller_name = seller_name;
        this.discounts = discounts;
        this.discount_price = discount_price;
        this.discount = discount;
    }

    public int getProduct_id() {
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

    public String getImagine() {
        return imagine;
    }

    public void setImagine(String imagine) {
        this.imagine = imagine;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public double getProduct_price() {
        return product_price;
    }

    public void setProduct_price(double product_price) {
        this.product_price = product_price;
    }

    public String getSeller_name() {
        return seller_name;
    }

    public void setSeller_name(String seller_name) {
        this.seller_name = seller_name;
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
        return "product{" +
                "product_id=" + product_id +
                ", product_name='" + product_name + '\'' +
                ", imagine='" + imagine + '\'' +
                ", parent_id=" + parent_id +
                ", category_id=" + category_id +
                ", product_price=" + product_price +
                ", seller_name=" + seller_name +
                ",boolean discounts=" + discounts +
                ",discount_price=" + discount_price +
                ",discount=" + discount +
                '}';
    }
}