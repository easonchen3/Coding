package com.springboot.springboot.chapter7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-18 19:51
 * @Version 1.0
 */
@RequestMapping("redis")
@RestController
public class testStringAndHash {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @Autowired
    private StringRedisTemplate stringRedisTemplate = null;

    @RequestMapping("stringAndHash")
    public Map<String,Object> testStringAndHash(){
        redisTemplate.opsForValue().set("key1","value1");
        redisTemplate.opsForValue().set("init_key","1");
        stringRedisTemplate.opsForValue().set("int","1");
        stringRedisTemplate.opsForValue().increment("int",1);

        Jedis jedis = (Jedis) stringRedisTemplate.getConnectionFactory().getConnection().getNativeConnection();
        jedis.decr("int");

        Map<String,Object> map = new HashMap<>();
        map.put("success",true);
        return map;
    }
}
