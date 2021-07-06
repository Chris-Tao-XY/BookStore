import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.wxapi.WxApiCall.WxApiCall;
import com.wxapi.model.RequestModel;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.*;

public class Test2 {
    @Test
    public void Test() {
        Jedis jedis = new Jedis("115.29.176.82", 6379);
        jedis.auth("114514");
        jedis.set("11", "121");
        System.out.println(jedis.get("11"));
    }

    @Test
    public void test01() {
        RequestModel model = new RequestModel();
        model.setGwUrl("https://way.jd.com/showapi/areaid");
        model.setAppkey("d8f64e389b98172147428e81e7ee2b24");
        Map queryMap = new HashMap();
        queryMap.put("area", "芜湖"); //访问参数
        model.setQueryParams(queryMap);
        WxApiCall call = new WxApiCall();
        call.setModel(model);
        Map<String, Object> json = JSONObject.parseObject(call.request());
        Map<String, Object> result = new HashMap<>();
        for (Object k : json.keySet()) {
            Object v = json.get(k);
            if (v instanceof JSONArray) {
                List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    Object json2 = it.next();
                    list.add(JSONObject.parseObject(json2.toString()));
                }
                result.put(k.toString(), list);
            } else {
                result.put(k.toString(), v);
            }
        }
        System.out.println(result);

//        if (maps.get("result") instanceof Map) {
//            Map<String, Object> maps1 = (Map<String, Object>) maps.get("result");
//            if (maps1.get("showapi_res_body") instanceof Map) {
//                Map<String, Object> map2 = (Map<String, Object>) maps1.get("showapi_res_body");
//                System.out.println(map2.get("list"));
//                if (map2.get("list") instanceof List) {
//                    if (((List) map2.get("list")).get(0) instanceof Map) {
//                        System.out.println(((Map<String, Object>) ((List) map2.get("list")).get(0)).get("distric"));
//
//                    }
//                }
//            }
//        }
    }
}
