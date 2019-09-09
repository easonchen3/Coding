package com.baiguo.other.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-16 14:40
 * @Version 1.0
 *
 *
 * 实现一个自旋锁
 * 通过CAS实现自旋操作
 */
public class SpinLockDemo {

    //原子引用线程
    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void mylock(){
        Thread thread = Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"\t come in ");
        while(!atomicReference.compareAndSet(null,thread)){
        }
    }

    public void myUnlock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
        System.out.println(Thread.currentThread().getName()+"\t invoked myUnlock");
    }

    public static void main(String[] args){

        SpinLockDemo spinLockDemo = new SpinLockDemo();

        new Thread(()->{
            spinLockDemo.mylock();
            try{ TimeUnit.SECONDS.sleep(5);} catch(InterruptedException e){e.printStackTrace(); }
            spinLockDemo.myUnlock();
        },"AA").start();

        try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){e.printStackTrace(); }

        new Thread(()->{
            spinLockDemo.mylock();
            try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){e.printStackTrace(); }
            spinLockDemo.myUnlock();
        },"BB").start();
    }


}
