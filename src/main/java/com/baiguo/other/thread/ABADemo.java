package com.baiguo.other.thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-12 08:37
 * @Version 1.0
 */
public class ABADemo {

    static AtomicReference<Integer> atomicReference = new AtomicReference<>(100);
    static AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100,1);

    public static void main(String[] args){

        new Thread(()->{
            atomicReference.compareAndSet(100,101);
            atomicReference.compareAndSet(101,100);
        },"t1").start();
        new Thread(()->{
            //t2 线程睡一秒。让t1线程完成一次ABA
            try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){e.printStackTrace(); }
            System.out.println(atomicReference.compareAndSet(100,2019)+"\t"+atomicReference.get());
        },"t2").start();

        try{ TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e){e.printStackTrace(); }
        System.out.println("====================================");

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号： "+stamp);
            try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){e.printStackTrace(); }
            atomicStampedReference.compareAndSet(100,101,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t第二次版本号： "+atomicStampedReference.getStamp());
            atomicStampedReference.compareAndSet(101,100,atomicStampedReference.getStamp(),atomicStampedReference.getStamp()+1);
            System.out.println(Thread.currentThread().getName()+"\t第三次版本号： "+atomicStampedReference.getStamp());
        },"t3").start();

        new Thread(()->{
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"\t第一次版本号： "+stamp);
            try{ TimeUnit.SECONDS.sleep(3);} catch(InterruptedException e){e.printStackTrace(); }
            boolean result = atomicStampedReference.compareAndSet(100,2019,stamp,stamp+1);
            System.out.println(Thread.currentThread().getName()+"\t"+result+"\t"+atomicStampedReference.getStamp());
            System.out.println("实际最新值为： "+atomicStampedReference.getReference());
        },"t4").start();

    }
}
