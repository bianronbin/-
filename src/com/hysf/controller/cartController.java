package com.hysf.controller;


import com.hysf.dao.UserDao;
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
    private UserDao userDao = new UserDaoImpl();
    cartDaoImpl cartDao = new cartDaoImpl();
    private UserService userService = new UserServiceImpl();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        //响应乱码
        resp.setContentType("text/html;charset=UTF-8");
        HttpSession session = req.getSession();

        // 获取登录用户id
        long id = (long) session.getAttribute("id");
        //获取加入购物车的商品id
        String product_idStr = req.getParameter("product_id");
        //获取加入购物车商品的数量（因为是点击加入购物车，默认数量为1）
        String amount = req.getParameter("amount");
        // 检查参数是否为 null 或空字符串
        if (product_idStr == null || product_idStr.isEmpty() || amount == null || amount.isEmpty()) {
            // 返回错误响应或设置默认值
            resp.getWriter().write("参数为空");
            return;
        }

        try {
            // 字符串转换为整数
            int product_id = Integer.parseInt(product_idStr);
            // 根据传的商品id，找到product表中此商品所有信息
            product product = userDao.queryProduct(product_id);
            //将商品加入到购物车中
            userService.addProductToCart(product, amount, id);
            System.out.println("添加成功");
            //调用printCart方法
            printCart(req, resp);
            req.getRequestDispatcher("/buy.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            // 返回错误响应或处理异常情况
            e.printStackTrace();
            resp.getWriter().write("参数错误");
        }
    }


    protected void updateCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        // 获取登录用户id
        long id = (long) session.getAttribute("id");
        //获取加入购物车商品的数量（这里从productAmount中获取数量）
        String amount1 = req.getParameter("productAmount");
        //获取加入购物车的商品id
        String product_idStr = req.getParameter("product_id");

        if (product_idStr == null || product_idStr.isEmpty() || amount1 == null || amount1.isEmpty()) {
            // 返回错误响应或设置默认值
            resp.getWriter().write("参数为空");
            return;
        }
        try {
            // 字符串转换为整数
            int product_id = Integer.parseInt(product_idStr);
            // 根据传的商品id，找到product表中此商品所有信息
            product product = userDao.queryProduct(product_id);
            //更新购物车中的商品信息
            cartDao.updateCard(product.getProduct_id(), amount1, id);
            System.out.println("更新成功");
            //调用printCart方法
            printCart(req, resp);
            req.getRequestDispatcher("/buy.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            // 返回错误响应或处理异常情况
            e.printStackTrace();
            resp.getWriter().write("参数错误");
        }
    }

    protected void deleteCart(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        // 获取登录用户id
        long id = (long) session.getAttribute("id");
        //获取加入购物车的商品id
        String product_idStr = req.getParameter("product_id");

        if (product_idStr == null || product_idStr.isEmpty()) {
            // 返回错误响应或设置默认值
            resp.getWriter().write("参数为空");
            return;
        }
        try {
            // 字符串转换为整数
            int product_id = Integer.parseInt(product_idStr);
            // 根据传的商品id，找到product表中此商品所有信息
            product product = userDao.queryProduct(product_id);
            //删除购物车中的商品
            cartDao.deleteProductFromCartDate(product.getProduct_id(), id);
            System.out.println("删除成功");
            //调用printCart方法
            printCart(req, resp);
            req.getRequestDispatcher("/buy.jsp").forward(req, resp);
        } catch (NumberFormatException e) {
            // 返回错误响应或处理异常情况
            e.printStackTrace();
            resp.getWriter().write("参数错误");
        }
    }

    // 获取新的购物车信息并保存到session中
    private void printCart(HttpServletRequest req, HttpServletResponse resp) {
        HttpSession session = req.getSession();
        List<cart> cart = cartDao.querycart();
        //保存到session的cart中
        session.setAttribute("cart", cart);

    }


}
