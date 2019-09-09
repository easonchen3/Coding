package com.baiguo.other.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-25 23:09
 * @Version 1.0
 */
public class CyclicBarrierDemo {
    
    public static void main(String[] args){
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> {
            System.out.println("****    召唤神龙    ****");
        });
        
        for(int i = 1; i <= 7; i++){
            final int temp = i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 收到第"+temp+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }
    }
}
