package com.hysf.dao.impl;

import com.hysf.dao.BaseDao;
import com.hysf.dao.parentDao;
import com.hysf.entity.parent;

import java.util.List;

public class parentDaoImpl extends BaseDao implements parentDao {
    /**
     * 遍历2级标签的信息
     *
     * @return
     */
    @Override
    public List<parent> queryParent() {
        String sql = "select * from parent ";
        return queryByList(parent.class, sql);

    }
}
