package redis;

import java.util.List;
import java.util.concurrent.TimeUnit;

import redis.clients.jedis.Jedis;

public class RedisJava {
    public static void main(String[] args) {
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("localhost", 6379);
        //查看服务是否运行
        //System.out.println("服务正在运行: "+jedis.ping());
        //System.out.println(jedis.get("aa"));
        //System.out.println(jedis.get("bb"));
        //jedis.set("bb", "b");
        //System.out.println(jedis.get("bb"));

        List<String> time = jedis.time();
        time.forEach(p -> {
                    System.out.println(p);

                }
        );

        time = jedis.time();

        time.forEach(p -> {
                    System.out.println(p);

                }
        );

        System.out.println(TimeUnit.SECONDS.toMillis(10));
    }
}
