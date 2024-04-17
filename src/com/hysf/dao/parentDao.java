package com.hysf.dao;

import com.hysf.entity.parent;

import java.util.List;

public interface parentDao {
    /**
     * 遍历2级标签的信息
     *
     * @return
     */
    public List<parent> queryParent();
}
