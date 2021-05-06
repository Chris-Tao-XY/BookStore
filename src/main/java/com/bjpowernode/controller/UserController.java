package com.bjpowernode.controller;

import com.bjpowernode.eception.AlreadyExistUserException;
import com.bjpowernode.eception.NotRegisterException;
import com.bjpowernode.pojo.User;
import com.bjpowernode.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/login")
    public Object login(@RequestBody User user, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        try {
            User loginUser = userService.loginUser(user);
            if (loginUser != null) {
                map.put("status", 1);
                map.put("user", loginUser);
                map.put("success", "登陆成功");
                request.getSession().setAttribute("user", loginUser);
                map.put("url", request.getContextPath() + "/staticResource/pages/user/login_success.html");
            } else {
                map.put("status", 2);
                map.put("username", user.getUsername());
                map.put("passwordWrong", "密码错误,登录失败");
            }
        } catch (NotRegisterException notRegisterException) {
            map.put("status", 3);
            map.put("username", user.getUsername());
            map.put("NotRegisterfailed", "用户" + user.getUsername() + "还未注册,请注册");
            map.put("url", request.getContextPath() + "/staticResource/pages/user/regist.html");
        }
        return map;
    }


    @RequestMapping("/regist")
    public Object regist(@RequestParam(value = "username") String username,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "code") String code,
                         @RequestParam(value = "email") String email,
            HttpServletRequest request) {
        User user=new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        Map<String, Object> map = new HashMap<>();
        String myKaptcha= (String) request.getSession().getAttribute("MY_KAPTCHA");
        request.getSession().removeAttribute("MY_KAPTCHA");
        System.out.println(myKaptcha);
        if(!Objects.equals(code,myKaptcha)){
            map.put("status",3);
            map.put("MyKaptchaWrong","验证码输入错误,请重试");
        }else {
            try {
                userService.registerUser(user);
                map.put("status",1);
                map.put("success","用户"+user.getUsername()+"注册成功");
                map.put("url",request.getContextPath()+"/staticResource/pages/user/login.html");
            }catch(AlreadyExistUserException alreadyExistUserException) {
                map.put("status",2);
                map.put("alreadyRegistedFailed","用户"+user.getUsername()+"已被注册");
                System.out.println("用户"+user.getUsername()+"已被注册");
            }
        }
        return map;
    }


    @RequestMapping("/logout")
    public Object loginout(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        request.getSession().removeAttribute("user");
        map.put("success","登出成功");
        map.put("url",request.getContextPath()+"/staticResource/index.html");
        return map;
    }

    @RequestMapping("/loginOrRegistSuccess")
    public Object success(HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        User user = (User) request.getSession().getAttribute("user");
        map.put("user",user);
        return map;
    }
}
