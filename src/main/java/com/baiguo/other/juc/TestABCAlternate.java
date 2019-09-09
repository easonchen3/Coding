package com.baiguo.other.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ABC 交替打印10次
 * @Author: BaoJian.Xu
 * @Date: 2019-07-31 13:03
 * @Version 1.0
 */
public class TestABCAlternate {
    public static void main(String[] args){
       AlternateDemo ad = new AlternateDemo();
       new Thread(() -> {
           for (int i =  1; i <= 20 ; i++) {
               ad.printA(i);
           }
       },"A").start();
        new Thread(() -> {
            for (int i =  1; i <= 20 ; i++) {
                ad.printB(i);
            }
        },"B").start();
        new Thread(() -> {
            for (int i =  1; i <= 20 ; i++) {
                ad.printC(i);
            }
        },"C").start();
    }
}
class AlternateDemo{
    private int num = 1; //当前正在执行线程标记
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printA(int totalLoop){
        lock.lock();
        try{
            //1.判断
            while(num!=1){
                condition1.await();
            }

            //2.打印
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }

            //3.唤醒
            num=2;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printB(int totalLoop){
        lock.lock();
        try{
            while(num!=2){
                condition2.await();
            }

            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }
            num=3;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void printC(int totalLoop){
        lock.lock();
        try{
            while(num!=3){
                condition3.await();
            }
            for (int i = 1; i <= 1; i++) {
                System.out.println(Thread.currentThread().getName()+"\t"+i+"\t"+totalLoop);
            }

            num=1;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

}
