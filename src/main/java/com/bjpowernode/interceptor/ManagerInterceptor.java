package com.bjpowernode.interceptor;


import com.alibaba.fastjson.JSONObject;
import com.bjpowernode.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ManagerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user")==null||!Objects.equals(((User) request.getSession().getAttribute("user")).getId(), 1)) {
            Map<String,Object> map=new HashMap<>();
            map.put("status",1);
            map.put("NotManager","请使用管理员账号登录");
            map.put("url",request.getContextPath()+"/staticResource/pages/user/login.html");
            JSONObject myJson=new JSONObject(map);
            String json=myJson.toString();
            response.getWriter().print(json);
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
