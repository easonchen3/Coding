package com.springboot.springboot.chapter3.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 21:52
 * @Version 1.0
 */
@Component
public class BeanPostProcessorExample implements BeanPostProcessor{

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessorExample.postProcessBeforeInitialization");
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessorExample.postProcessAfterInitialization");
        return bean;
    }
}
