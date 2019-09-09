package com.springboot.springboot.chapter3.pojo;

import com.springboot.springboot.chapter3.pojo.definition.Animal;
import com.springboot.springboot.chapter3.pojo.definition.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-10 13:53
 * @Version 1.0
 */
@Component
public class BussinessPerson implements Person,BeanNameAware,
        BeanFactoryAware,ApplicationContextAware,InitializingBean,DisposableBean{

    private Animal animal = null;

    @Override
    public void service() {
        this.animal.use();
    }

    @Override
    @Autowired @Qualifier("dog")
    public void setAnimal(Animal animal) {
        System.out.println("延迟依赖注入");
        this.animal = animal;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("BussinessPerson.setBeanName");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("BussinessPerson.setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("BussinessPerson.setApplicationContext");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("BussinessPerson.afterPropertiesSet");
    }

    @PostConstruct
    public void init(){
        System.out.println("BussinessPerson.init");
    }

    @PreDestroy
    public void destory1(){
        System.out.println("BussinessPerson.destory1");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("BussinessPerson.destroy");
    }
}
