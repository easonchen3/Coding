package com.baiguo.other.juc;

import java.util.concurrent.TimeUnit;

/**
 * 判断打印的是 one  or two
 *
 * 1. 两个普通同步方法 两个线程标准打印//  one  two
 * 2. 新增sleep方法给 getOne，//        one  two
 * 3. 新增普通方法，getThree //         three one two
 * 4. 两个普通的同步方法。两个Number对象  two   one
 * 5. 修改getOne为静态同步方法，         two   one
 * 6. 修改两个方法都是静态同步方法，一个number对象   one two
 * 7. 一个静态同步方法，一个非静态同步方法，两个number对象 two one
 * 8. 两个静态同步方法，两个Number对象     one  two
 *
 * 线程八锁的关键：
 *  1，非静态方法的锁默认为this ,静态方法的锁对应为CLass实例
 *  2. 某一个时刻内只能有一个线程持有锁，无论几个方法
 * @Author: BaoJian.Xu
 * @Date: 2019-07-31 13:25
 * @Version 1.0
 */
public class TestThread8Monitor {
    public static void main(String[] args){
       Number number = new Number();
       Number numer1 = new Number();
       new Thread(() -> {
           number.getOne();
       },"A").start();
       new Thread(() -> {
           numer1.getTwo();
           //number.getTwo();
       },"B").start();

       /*new Thread(() -> {
           number.getThree();
       },"C").start();*/
    }
}

class Number {
    public static synchronized void getOne() {
        try{ TimeUnit.SECONDS.sleep(3);} catch(InterruptedException e){e.printStackTrace(); }
        System.out.println("one");
    }

    public static synchronized void getTwo() {
        System.out.println("two");
    }

    public void getThree(){
        System.out.println("three");
    }
}