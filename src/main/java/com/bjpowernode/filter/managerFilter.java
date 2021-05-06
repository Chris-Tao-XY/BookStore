package com.bjpowernode.filter;



import com.bjpowernode.pojo.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/staticResource/pages/manager/book_edit.html","/staticResource/pages/manager/manager.html"})
public class managerFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest= (HttpServletRequest) servletRequest;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        if(user==null||!"admin".equals(user.getUsername())){
            ((HttpServletResponse) servletResponse).sendRedirect(httpServletRequest.getContextPath()+"/staticResource/pages" +
                    "/user" +
                    "/login.html");
        }else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
