package com.springboot.springboot.chapter4;

import com.springboot.springboot.chapter4.interceptor.MyInterceptor;
import com.springboot.springboot.chapter4.proxy.ProxyBean;
import com.springboot.springboot.chapter4.service.HelloService;
import com.springboot.springboot.chapter4.service.impl.HelloServiceImpl;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:37
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args){
        HelloService helloService = new HelloServiceImpl();
        HelloService proxy = (HelloService) ProxyBean.getProxyBean(helloService,new MyInterceptor());
        proxy.sayHello("zs");
        System.out.println("***************************");
        proxy.sayHello(null);
    }
}
