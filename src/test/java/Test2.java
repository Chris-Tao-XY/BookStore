import org.junit.Test;
import redis.clients.jedis.Jedis;

public class Test2 {
    @Test
    public void Test(){
        Jedis jedis = new Jedis("115.29.176.82",6379);
        jedis.auth("114514");
        jedis.set("11","121");
        System.out.println(jedis.get("11"));
    }

}
