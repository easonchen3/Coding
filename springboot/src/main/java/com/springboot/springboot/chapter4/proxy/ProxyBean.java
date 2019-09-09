package com.springboot.springboot.chapter4.proxy;

import com.springboot.springboot.chapter4.interceptor.Interceptor;
import com.springboot.springboot.chapter4.invoke.Invocation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-11 16:31
 * @Version 1.0
 */
public class ProxyBean implements InvocationHandler {

    private Object target = null;

    private Interceptor interceptor = null;

    public static Object getProxyBean(Object target, Interceptor interceptor){
        ProxyBean proxyBean = new ProxyBean();
        proxyBean.target = target;
        proxyBean.interceptor = interceptor;
        Object proxy = Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),
                proxyBean);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        boolean exceptionFlag = false;
        Invocation invocation = new Invocation(args,method,target);
        Object retObj = null;
        try{
            if(this.interceptor.useAround()){
                retObj = this.interceptor.around(invocation);
            }else{
                retObj = method.invoke(target,args);
            }
        }catch (Exception e){
            exceptionFlag = true;
        }
        this.interceptor.after();
        if(exceptionFlag){
            this.interceptor.afterThrowing();
        }else{
            this.interceptor.afterReturning();
            return retObj;
        }

        return null;
    }
}
