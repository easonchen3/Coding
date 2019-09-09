package com.baiguo.other.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池的体系结构
 *  java.util.concurrent.Executor
 *      --ExecutorService       线程池的主要接口
 *          --ThreadPoolExecutor 线程池的实现类
 *          --ScheduledExecutorService 子接口，负责线程调度
 *              --ScheduledThreadPoolExecutor: 继承ThreadPoolExecutor 实现ScheduledExecutorService
 *
 * Executors.newFixedThreadPool()   //定长线程池
 * Executors.newCachedThreadPool()  //缓存线程池
 * Executors.newSingleThreadExecutor()//单个线程池
 * Executors.newScheduledThreadPool()//固定可以调度线程池 延迟定时执行任务
 * @Author: BaoJian.Xu
 * @Date: 2019-07-31 13:40
 * @Version 1.
 */
public class TestThreadPool {
    public static void main(String[] args){
        ExecutorService pool = Executors.newFixedThreadPool(5);
        ThreadPoolDemo tpd = new ThreadPoolDemo();

        for (int i = 0; i < 10; i++) {
            pool.submit(new ThreadPoolDemo());
        }
        pool.shutdown();
    }
}
class ThreadPoolDemo implements Runnable{

    private int i = 0;

    @Override
    public void run() {
        try{ TimeUnit.SECONDS.sleep(1);} catch(InterruptedException e){e.printStackTrace(); }
        System.out.println(Thread.currentThread().getName());
    }

}
