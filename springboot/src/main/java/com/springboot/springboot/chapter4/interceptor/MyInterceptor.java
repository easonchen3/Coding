package com.springboot.springboot.chapter4.interceptor;

import com.springboot.springboot.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:29
 * @Version 1.0
 */
public class MyInterceptor implements  Interceptor {
    @Override
    public boolean before() {
        System.out.println("MyInterceptor.before");
        return true;
    }

    @Override
    public void after() {
        System.out.println("MyInterceptor.after");
    }

    @Override
    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException {
        System.out.println("around before ...");
        Object obj = invocation.proceed();
        System.out.println("around after...");
        return obj;
    }

    @Override
    public void afterReturning() {
        System.out.println("MyInterceptor.afterReturning");
    }

    @Override
    public void afterThrowing() {
        System.out.println("MyInterceptor.afterThrowing");
    }

    @Override
    public boolean useAround() {
        return true
                ;
    }
}
