package com.bjpowernode.text;

import com.bjpowernode.viewObject.Person;
import com.google.gson.Gson;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


/**
 * @Controller:创建处理器对象，对象放在springmvc容器中。
 * 在类上面
 * 和spring中讲的@Service,@Component,@Repository
 * 一样
 */
@RequestMapping("/test")
@Controller
public class MyController {
    /**
     * 处理用户请求，springmvc中是使用方法来处理的
     * 方法是自定义的
     */
    /**
     * 准备使用doSome方法处理Some.do请求
     *
     * @return
     * @RequestMapping请求映射，作用是把一个请求地址和一个方法绑定在一起，一个请求一个方法处理
     */

    /**
     * 能处理请求的得到都叫控制器对象，也叫后端控制器
     */
    @RequestMapping(value = "/some.do",method = RequestMethod.GET/*不加就是不指定请求方式*/)
    public ModelAndView doSome() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "欢迎使用springmvc做web开发");
        modelAndView.addObject("fun","doSome方法");
        modelAndView.setViewName("show");
        return modelAndView;
    }
    @RequestMapping(value = "/other.do"/*method = RequestMethod.GET不加就是不指定请求方式*/)
    public ModelAndView doOther(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("msg", "欢迎使用springmvc做web开发"+request.getParameter("name"));
        modelAndView.addObject("fun","doSome方法");
        modelAndView.setViewName("show");
        return modelAndView;
    }
    @RequestMapping(value = "/other1.do"/*method = RequestMethod.GET不加就是不指定请求方式*/)
    public ModelAndView doOther1(@RequestParam(value = "rname",required = false) String name,
                                 @RequestParam(value = "rage",required = false) Integer age) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myName","名字是"+name);
        modelAndView.addObject("myAge","年龄是"+age);
        modelAndView.setViewName("table");
        return modelAndView;
    }
    @RequestMapping(value = "/other2.do")
    public void doOther2(String name,Integer age,HttpServletResponse response) throws IOException {
        Map<String,Object> map=new HashMap<>();
        map.put("myName",name);
        map.put("myAge",age);
        Gson gson = new Gson();
        String json = gson.toJson(map);
        response.getWriter().write(json);
    }

    @RequestMapping(value = "/other3.do")
    @ResponseBody
    public Person doOther3(String name, Integer age, HttpServletResponse response) throws IOException {
        return new Person(name,age);
    }
}
