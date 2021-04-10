package redis;

import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTools {

    public static final String REDIS_HOST = "q9ypredis-1.800best.com";

    public static final int REDIS_PORT = 6006;

    public static final int REDIS_TO = 10000;

    public static final String REDIS_AUTH = "q9ypredis";

    public static void main(String[] args) throws Exception {
        //连接本地的 Redis 服务


        JedisPoolConfig config = new JedisPoolConfig();

        JedisPool jedisPool = new JedisPool(config, REDIS_HOST, REDIS_PORT, REDIS_TO, REDIS_AUTH);

        Jedis jedis = jedisPool.getResource();

        //String s = jedis.get("pkg_bill_code_eprovide:047");

        List<String> pkgCodes = jedis.brpop(5, "pkg_bill_code_eprovide:047");
        System.out.printf(pkgCodes.get(1));

    }
}
