package com.hysf.dao.impl;

import com.hysf.dao.BaseDao;
import com.hysf.dao.categoryDao;
import com.hysf.entity.category;

import java.util.List;

public class categoryDaoImpl extends BaseDao implements categoryDao {
    /**
     * 遍历1级标签的信息
     *
     * @return
     */
    @Override
    public List<category> queryCategory() {
        String sql = "select * from category ";
        return queryByList(category.class, sql);
    }
}
