package com.springboot.springboot.chapter4.aspect;

import com.springboot.springboot.chapter4.aspect.validator.UserValidator;
import com.springboot.springboot.chapter4.aspect.validator.impl.UserValidatorImpl;
import org.aspectj.lang.annotation.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:51
 * @Version 1.0
 */
@Aspect
public class MyAspect {

    @DeclareParents(
            value = "com.springboot.springboot.chapter4.aspect.service.impl.UserServiceImpl",
            defaultImpl = UserValidatorImpl.class)
    public UserValidator userValidator;

    @Pointcut("execution(* com.springboot.springboot.chapter4.aspect.service.impl.UserServiceImpl.printUser(..))")
    public void pointCut(){
    }

    @Before("pointCut()")
    public void before(){
        System.out.println("MyAspect.before");
    }
    @After("pointCut()")
    public void after(){
        System.out.println("MyAspect.after");
    }

    @AfterReturning("pointCut()")
    public void afterReturning(){
        System.out.println("MyAspect.afterReturning");
    }

    @AfterThrowing("pointCut()")
    public void afterThrowing(){
        System.out.println("MyAspect.afterThrowing");
    }
}
