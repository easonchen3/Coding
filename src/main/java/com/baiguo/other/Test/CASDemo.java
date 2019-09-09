package com.baiguo.other.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-04 16:33
 * @Version 1.0
 *
 *
 * 1. CAS 是什么 -----》CompareAndSet
 *      比较并交换
 */
public class CASDemo {
    public static void main(String[] args){

        AtomicInteger atomicInteger = new AtomicInteger(5);

        System.out.println(atomicInteger.compareAndSet(5,2019)+"\t current data :"+atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5,1024)+"\t current data :"+atomicInteger.get());
    }
}
