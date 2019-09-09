package com.baiguo.other.juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-01 13:37
 * @Version 1.0
 */
public class TestCallable {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadDemos tds = new ThreadDemos();
        FutureTask<Integer> result = new FutureTask<>(tds);
        new Thread(result).start();

        System.out.println(result.get());
    }
}

class ThreadDemos implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}