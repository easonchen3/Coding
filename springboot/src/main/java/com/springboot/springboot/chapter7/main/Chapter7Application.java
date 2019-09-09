package com.springboot.springboot.chapter7.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-18 19:46
 * @Version 1.0
 */
@SpringBootApplication(scanBasePackages = "com.springboot.springboot.chapter7")
public class Chapter7Application {

    @Autowired
    private RedisTemplate redisTemplate = null;

    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    private void initRedisTemplate(){
        RedisSerializer serializer = redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
    }

    public static void main(String[] args){
        SpringApplication.run(Chapter7Application.class);
    }
}
