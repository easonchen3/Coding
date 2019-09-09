package com.springboot.springboot.chapter4.invoke;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:25
 * @Version 1.0
 */
public class Invocation {

    private Object[] params;
    private Method method;
    private Object target;

    public Invocation(Object[] params,Method method,Object target){
        this.params = params;
        this.method = method;
        this.target = target;
    }

    public Object proceed() throws InvocationTargetException, IllegalAccessException {
        return method.invoke(target,params);
    }
}
