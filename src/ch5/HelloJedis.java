package ch5;

import redis.clients.jedis.Jedis;

public class HelloJedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        String result = jedis.set("redisbook", "Hello Jedis!");
        System.out.println(result);
        System.out.println(jedis.get("redisbook"));
    }
}
