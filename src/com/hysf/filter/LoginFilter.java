package com.hysf.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig fiterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        Object user = req.getSession().getAttribute("username");
        if (user == null) {
            //未登录成功请求转发到登录页面
            req.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        } else {
            //如果登录成功就放行
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }

}
