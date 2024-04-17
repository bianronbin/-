package com.hysf.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        //响应乱码
        resp.setContentType("text/html;charset=UTF-8");
        //获取请求参数
        getMethod(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        //响应乱码
        resp.setContentType("text/html;charset=UTF-8");
        //获取请求参数
        getMethod(req, resp);
    }

    private void getMethod(HttpServletRequest req, HttpServletResponse resp) {
        String action = req.getParameter("action");
        try {
            //知道是当前类的哪个方法
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            //调用目标业务方法
            method.invoke(this, req, resp);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
