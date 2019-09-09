package com.springboot.springboot.chapter4.interceptor;

import com.springboot.springboot.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationTargetException;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:24
 * @Version 1.0
 */
public interface Interceptor {

    public boolean before();

    public void after();

    public Object around(Invocation invocation) throws InvocationTargetException, IllegalAccessException;

    public void afterReturning();

    public void afterThrowing();

    boolean useAround();
}
