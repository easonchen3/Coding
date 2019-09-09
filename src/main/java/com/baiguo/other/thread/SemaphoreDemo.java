package com.baiguo.other.thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-25 23:22
 * @Version 1.0
 */
public class SemaphoreDemo {

    public static void main(String[] args){
        Semaphore semaphore = new Semaphore(3);//模拟三个停车位

        //模拟6个车子进三个停车位
        for(int i = 1; i <= 6; i++){
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"\t 抢到车位了");
                    try{ TimeUnit.SECONDS.sleep( 3 );} catch(InterruptedException e){e.printStackTrace(); }
                    System.out.println(Thread.currentThread().getName()+"\t 听三秒了之后离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }
    }
}
