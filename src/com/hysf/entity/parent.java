package com.hysf.entity;

/**
 * int parent_id           2级标签id
 * String parent_name      2级标签名
 * int category_id         属于的1级标签id
 */
public class parent {
    private int parent_id;
    private String parent_name;
    private int category_id;


    public parent() {
    }

    public parent(int parent_id, String parent_name, int category_id) {
        this.parent_id = parent_id;
        this.parent_name = parent_name;
        this.category_id = category_id;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public String getParent_name() {
        return parent_name;
    }

    public void setParent_name(String parent_name) {
        this.parent_name = parent_name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    @Override
    public String toString() {
        return "parent{" +
                "parent_id=" + parent_id +
                ", parent_name='" + parent_name + '\'' +
                ", category_id=" + category_id +
                '}';
    }
}
