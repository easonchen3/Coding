package com.spring.第一节课;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-16 12:59
 * @Version 1.0
 */
public class MainClass {
    public static void main(String[] args){
        //创建一个IOC容器
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);
        //直接从IOC的单例池中拿bean
        InstanceA bean = ctx.getBean(InstanceA.class);
        ctx.close();
    }
}
