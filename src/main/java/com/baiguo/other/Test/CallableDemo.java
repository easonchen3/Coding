package com.baiguo.other.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-30 21:58
 * @Version 1.0
 */
class MyThread implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("*********come in callable");
        try{ TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e){e.printStackTrace(); }
        return 1024;
    }
}
public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        Thread t1 = new Thread(futureTask,"AAA");
        t1.start();

        int result = 100;

        while(!futureTask.isDone()){

        }
        int result2 = futureTask.get();
        System.out.println("result = "+(result+result2));

    }
}
