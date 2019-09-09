package com.baiguo.other.Test.prodConsumer;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{ //资源类
    private int num = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increate()throws Exception{
        lock.lock();
        try{
            //1.判断
            while(num != 0){
                //等待不能去生产
                condition.await();
            }
            num++;
            System.out.println(Thread.currentThread().getName()+"\t "+num);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void decrement()throws Exception{
        lock.lock();
        try{
            //1.判断
            while(num == 0){
                //等待不能去生产
                condition.await();
            }
            num--;
            System.out.println(Thread.currentThread().getName()+"\t "+num);
            //通知唤醒
            condition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-30 00:12
 * @Version 1.0
 *
 * 初始化一个为0的变量，两个线程对其交替操作 ， 一个加1 一个减1 ， 来5轮
 *
 *
 * 1. 线程    操作      资源类
 * 2. 判断    干活      通知
 * 3. 防止虚假唤醒机制
 */
public class ProdConsumer_TraditionDemo {
    public static void main(String[] args){
       ShareData shareData = new ShareData();
       
       new Thread(() -> {
           for (int i = 0; i < 5; i++) {
               try {
                   shareData.increate();
               } catch (Exception e) {
                   e.printStackTrace();
               }
           }
       },"AAA").start();

        new Thread(() -> {
            for (int i = 0; i < 5; i++) {
                try {
                    shareData.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },"BBB").start();
    }
}
