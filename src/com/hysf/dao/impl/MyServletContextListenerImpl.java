package com.hysf.dao.impl;

import com.hysf.entity.category;
import com.hysf.entity.product;
import com.hysf.entity.parent;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.List;

/**
 * 初始化数据
 */
public class MyServletContextListenerImpl implements ServletContextListener {
    UserDaoImpl userDao = new UserDaoImpl();
    categoryDaoImpl category = new categoryDaoImpl();
    parentDaoImpl parent = new parentDaoImpl();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //初始化标签数据
        List<category> categories = category.queryCategory();
        List<parent> parents = parent.queryParent();
        //初始化商品数据
        List<product> products = userDao.queryProduct();
        // 将产品列表存储在 ServletContext 中
        ServletContext context = sce.getServletContext();
        context.setAttribute("categories", categories);
        context.setAttribute("parents", parents);
        context.setAttribute("products", products);

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

