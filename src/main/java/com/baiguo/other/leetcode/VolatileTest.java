package com.baiguo.other.leetcode;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-05-13 18:43
 * @Version 1.0
 */
class MyData {

    volatile int num = 0;

    public void addTo60() {
        num = 60;
    }

    public void addPlusPlus() {//此时num前面加了volatile关键字
        num++;
    }

    AtomicInteger atomicInteger = new AtomicInteger(0);

    public void addAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1.验证volatile的可见性
 * 1.1 int num = 0; number 变量之前根本没有添加volatile 关键字修饰，没有可见性
 * 1.2 添加volatile之后，可以解决可见性问题
 *
 *
 * 2.验证volatile不保证原子性问题
 * 2.1 原子性指什么问题，不可分割，完整性，某个线程正在做某个业务的时候不可以被加塞或者分割，要么同时成功要么同时失败。
 *
 * 2.2 volatile 不保证原子性操作
 *
 * 2.3 why
 *
 * 2.4 如何解决原子性
 *  加 synchronized
 *  直接使用我们的JUC 下的AtomicInteger
 *
 */

public class VolatileTest {


    public static void main(String[] args) {
        MyData data = new MyData();
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    data.addPlusPlus();
                    data.addAtomic();
                }
            }, String.valueOf(i)).start();
        }

        //等待计算完毕,看返回结果
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + "\t int  finally number value: " + data.num);
        System.out.println(Thread.currentThread().getName() + "\t atomicInteger finally number value: " + data.atomicInteger);
    }

    private static void seeOkByVolatile() { //volatile 可以保证可见性
        MyData data = new MyData();
        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t update value is " + data.num);
        }, "AAA").start();

        /*while (data.num == 0) {

        }*/

        System.out.println(Thread.currentThread().getName() + "\t mission is over");
    }


}
