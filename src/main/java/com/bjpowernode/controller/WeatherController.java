package com.bjpowernode.controller;


import com.google.gson.Gson;
import com.wxapi.WxApiCall.WxApiCall;
import com.wxapi.model.RequestModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/weather")
public class WeatherController {
    @RequestMapping("/weather")
    public Object getWeather(HttpServletResponse response) throws IOException {
        RequestModel model = new RequestModel();
        model.setGwUrl("https://way.jd.com/showapi/areaid");
        model.setAppkey("d8f64e389b98172147428e81e7ee2b24");
        Map queryMap = new HashMap();
        queryMap.put("area", "芜湖"); //访问参数
        model.setQueryParams(queryMap);
        WxApiCall call = new WxApiCall();
        call.setModel(model);
        Gson gson = new Gson();
        String json = gson.toJson(call.request());
        Object result = gson.fromJson(call.request(), Object.class);
        return result;
    }
}
