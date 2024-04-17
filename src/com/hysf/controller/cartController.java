package com.hysf.controller;


import com.hysf.dao.UserDao;
import com.hysf.dao.cartDao;
import com.hysf.dao.impl.UserDaoImpl;
import com.hysf.dao.impl.cartDaoImpl;
import com.hysf.entity.cart;
import com.hysf.entity.product;
import com.hysf.service.UserService;
import com.hysf.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;


public class cartController extends BaseServlet {
    private  UserDao userDao = new UserDaoImpl();
    cartDaoImpl cartDao = new cartDaoImpl();
    private  UserService userService = new UserServiceImpl();


    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //响应乱码
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();

        // 获取请求参数
        long id = (long) session.getAttribute("id");
        String product_idStr = req.getParameter("product_id");
        String amount = req.getParameter("amount");
        // 检查参数是否为 null 或空字符串
        if (product_idStr == null || product_idStr.isEmpty() || amount == null || amount.isEmpty()) {
            // 返回错误响应或设置默认值
            resp.getWriter().write("参数为空");
            return;
        }
        // 尝试将字符串转换为整数
        try {
            int product_id = Integer.parseInt(product_idStr);
            // 继续处理 id, product_id, amount
            product product = userDao.queryProduct(product_id);
            userService.addProductToCart(product, amount, id);
            System.out.println("添加成功");
            List<cart> cart =cartDao.querycart();
            session.setAttribute("cart",cart);
            req.getRequestDispatcher("/buy.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            // 返回错误响应或处理异常情况
            e.printStackTrace();
            resp.getWriter().write("参数错误");
        }
    }



    protected void updateCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //响应乱码
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        //获取请求参数
        long id = (long) session.getAttribute("id");
        String amount1 = req.getParameter("productAmount");
        String product_idStr = req.getParameter("product_id");

        if (product_idStr == null || product_idStr.isEmpty() || amount1 == null || amount1.isEmpty()) {
            // 返回错误响应或设置默认值
            resp.getWriter().write("参数为空");
            return;
        }
        // 尝试将字符串转换为整数
        try {
            int product_id = Integer.parseInt(product_idStr);
            // 继续处理 id, product_id, amount
            product product = userDao.queryProduct(product_id);
            cartDao.updateCard(product.getProduct_id(), amount1, id);
            System.out.println("更新成功");
            List<cart> cart =cartDao.querycart();
            session.setAttribute("cart",cart);
            req.getRequestDispatcher("/buy.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            // 返回错误响应或处理异常情况
            e.printStackTrace();
            resp.getWriter().write("参数错误");
        }
    }

    protected void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //响应乱码
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();
        //获取请求参数
        long id = (long) session.getAttribute("id");
        String product_idStr = req.getParameter("product_id");

        if (product_idStr == null || product_idStr.isEmpty()) {
            // 返回错误响应或设置默认值
            resp.getWriter().write("参数为空");
            return;
        }
        // 尝试将字符串转换为整数
        try {
            int product_id = Integer.parseInt(product_idStr);
            // 继续处理 id, product_id, amount
            product product = userDao.queryProduct(product_id);
            cartDao.deleteProductFromCartDate(product.getProduct_id(), id);
            System.out.println("删除成功");
            List<cart> cart =cartDao.querycart();
            session.setAttribute("cart",cart);
            req.getRequestDispatcher("/buy.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            // 返回错误响应或处理异常情况
            e.printStackTrace();
            resp.getWriter().write("参数错误");
        }
    }
}
