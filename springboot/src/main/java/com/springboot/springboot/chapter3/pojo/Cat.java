package com.springboot.springboot.chapter3.pojo;

import com.springboot.springboot.chapter3.pojo.definition.Animal;
import org.springframework.stereotype.Component;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 14:01
 * @Version 1.0
 */
@Component
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("猫【"+Cat.class.getSimpleName()+"】是用来抓老鼠的");
    }
}
