package com.hebeu.ask.web.redis;

import com.alibaba.fastjson.JSONArray;
import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.List;

/**
 * @author : chenDeHua
 * Time   : 2018/5/22 上午10:16
 * Desc   : jedis工具类
 **/

@Slf4j
public class JedisUtil {
    /** Redis地址 */
    private static String redisAddress = "47.94.251.186";
    /** port */
    private static int redisPort = 6379;
    /** 密码 */
    private static String password = "cdh19950820";
    /** 超时时间 */
    private static int redisTimeout = 2000;

    /**
     * 配置连接池，连接对象，其中jedisPoolConfig对象可以操控连接的空闲时间、连接个数等等，这里采用默认方式
     */
    private static JedisPool pool = new JedisPool(new JedisPoolConfig(), redisAddress, redisPort, redisTimeout, password);
    private static Jedis jedis = null;

    static {
        getJedis();
    }

    private static Jedis getJedis() {
        jedis = pool.getResource();
        return jedis;
    }

    public static void del(String key){
        jedis.del(key);
    }

    public static String set(String key, String value) {
        return jedis.set(key, value);
    }

    public static String get(String key) {
        return jedis.get(key);
    }

    /**
     * 设置 list
     *
     * @param <T>
     * @param key
     */
    public static <T> void setList(String key, List<T> list) {
        try {
            jedis.set(key, JSONArray.toJSONString(list));
        } catch (Exception e) {
            log.error("Set key error : " + e);
        }
    }

    /**
     * 获取list
     *
     * @param <T>
     * @param key
     * @return list
     */
    public static <T> List<T> getList(String key, Class c) {
        if (jedis == null || !jedis.exists(key)) {
            return null;
        }
        String text = jedis.get(key);
        List<T> list = (List<T>) JSONArray.parseArray(text, c);
        return list;
    }

}