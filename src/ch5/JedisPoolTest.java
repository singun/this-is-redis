package ch5;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Map;

public class JedisPoolTest {

    public static void main(String[] args) {
        JedisPool jedisPool = new JedisPool("127.0.0.1", 6379);
        Jedis firstClient = jedisPool.getResource();
        firstClient.hset("info:신대욱", "이름", "신대욱");
        firstClient.hset("info:신대욱", "생일", "1987-08-22");

        Jedis secondClient = jedisPool.getResource();
        Map<String, String> result = secondClient.hgetAll("info:신대욱");
        System.out.println("이름 : " + result.get("이름"));
        System.out.println("생일 : " + result.get("생일"));

        jedisPool.returnResourceObject(firstClient);
        jedisPool.returnResourceObject(secondClient);
        jedisPool.destroy();
    }
}
