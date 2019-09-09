package com.springboot.springboot.chapter3.pojo;

import com.springboot.springboot.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 13:54
 * @Version 1.0
 */
@Component
public class Dog implements Animal {
    @Override
    public void use() {
        System.out.println("狗【"+Dog.class.getSimpleName()+"】是看门用的");
    }
}
