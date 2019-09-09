package com.baiguo.other.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-01 13:44
 * @Version 1.0
 */
public class TestLock {
    public static void main(String[] args){
        Ticket ticket = new Ticket();
       for(int i = 1; i <= 3; i++){
           new Thread(ticket, i+"号窗口").start();
       }
    }
}

class Ticket implements Runnable{

    private int tick = 100;

    private Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true){
            lock.lock();
            try{
                if(tick>0){
                    try{ TimeUnit.MILLISECONDS.sleep(200 );} catch(InterruptedException e){e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"完成售票。剩为： "+ --tick);
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        }
    }
}