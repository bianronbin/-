package com.hysf.dao;

import com.hysf.entity.category;

import java.util.List;

public interface categoryDao {
    /**
     * 遍历1级标签的信息
     *
     * @return
     */
    public List<category> queryCategory();
}
