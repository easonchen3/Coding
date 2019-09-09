package com.baiguo.other.Test1;

import java.util.concurrent.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-01 14:33
 * @Version 1.0
 * 第四种获取、使用多线程的方式，线程池
 */
public class MyThreadPoolDemo {

    public static void main(String[] args){


        ExecutorService threadpool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());

        //模拟10 个用户来办理业务，每个用户都是一个外部的请求
        try{
            for (int i = 1; i <= 10; i++) {
                threadpool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //try{ TimeUnit.MILLISECONDS.sleep(200);} catch(InterruptedException e){e.printStackTrace(); }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadpool.shutdown();
        }
    }

    public static void threadPoolnit() {
        // Array Arrays
        // Collection Collections
        // Executor Executors
        //ExecutorService threadpool = Executors.newFixedThreadPool(5);//一池5个处理线程   适用于执行长期的任务，性能很好
        //ExecutorService threadpool = Executors.newSingleThreadExecutor();//一池1个处理线程  单例 适用于一个任务执行场景
        ExecutorService threadpool = Executors.newCachedThreadPool(); //一池N个线程  适用于执行很多短期异步的小程序或者负载较轻的服务器

        //模拟10 个用户来办理业务，每个用户都是一个外部的请求
        try{
            for (int i = 1; i <= 10; i++) {
                threadpool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"\t 办理业务");
                });
                //try{ TimeUnit.MILLISECONDS.sleep(200);} catch(InterruptedException e){e.printStackTrace(); }
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            threadpool.shutdown();
        }
    }
}
