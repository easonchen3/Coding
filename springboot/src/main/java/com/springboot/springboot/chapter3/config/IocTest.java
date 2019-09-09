package com.springboot.springboot.chapter3.config;

import com.springboot.springboot.chapter3.pojo.BussinessPerson;
import com.springboot.springboot.chapter3.pojo.User;
import com.springboot.springboot.chapter3.pojo.definition.Person;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 13:29
 * @Version 1.0
 */
public class IocTest {

    private static Logger logger = Logger.getLogger(IocTest.class);
    public static void main(String[] args){
        //AnnotationConfigApplicationContext ctx =
        //       new AnnotationConfigApplicationContext(AppConfig.class);
        //Person person = ctx.getBean(BussinessPerson.class);
        //person.service();
        //ctx.close();
    }
}
