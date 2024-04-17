package com.hysf.controller;

import com.hysf.dao.UserDao;
import com.hysf.dao.impl.UserDaoImpl;
import com.hysf.dao.impl.cartDaoImpl;
import com.hysf.dao.impl.parentDaoImpl;
import com.hysf.entity.User;
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


public class UserController extends BaseServlet {
    cartDaoImpl cartDao = new cartDaoImpl();
    private UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user=userService.login(username, password);

        if (userService.login(username, password) == null) {
            // 表示登录失败

            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        } else {
            // 表示登录成功
            HttpSession session = req.getSession();
            // 设置当前 Session一周后超时
            session.setMaxInactiveInterval(60*60*24*7);

            session.setAttribute("username", username);
            session.setAttribute("password", password);
            session.setAttribute("id", user.getId());
            //获取购物车信息
            List<cart> cart =cartDao.querycart();
            //存放到session中
            session.setAttribute("cart",cart );
            req.getRequestDispatcher("/login_success.jsp").forward(req, resp);
        }
    }

    protected void register(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        // 检查用户名是否可用
        if (userService.existsUserName(username)) {
            System.out.println("用户名【 " + username + "】 不可用");
            // 重新跳回到注册页面
            req.getRequestDispatcher("/register.jsp").forward(req, resp);
        } else {
            // 表示可用
            // 调用userService里面的注册方法
            userService.registerUser(new User(null, username, password, email, "1", "唱跳篮球", null, null, null));
            // 跳转到注册成功页面
            req.getRequestDispatcher("/register_success.jsp").forward(req, resp);
        }
    }

}