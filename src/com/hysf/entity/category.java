package com.hysf.entity;

/**
 * int category_id           1 级标签
 * String category_name      1级标签名
 */
public class category {
    private int category_id;
    private String category_name;

    public category(int category_id, String category_name) {
        this.category_id = category_id;
        this.category_name = category_name;
    }

    public category() {
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    @Override
    public String toString() {
        return "category{" +
                "category_id=" + category_id +
                ", category_name='" + category_name + '\'' +
                '}';
    }
}
