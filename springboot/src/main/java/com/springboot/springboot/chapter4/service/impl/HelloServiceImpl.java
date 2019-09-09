package com.springboot.springboot.chapter4.service.impl;

import com.springboot.springboot.chapter4.service.HelloService;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:22
 * @Version 1.0
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello(String name) {
        if(name == null || name.trim().equals("")){
            throw new RuntimeException("paramter is null !");
        }
        System.out.println("hello "+name);
    }
}
