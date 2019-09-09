package com.baiguo.other.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-24 16:53
 * @Version 1.0
 */
public class CountDownLatchDemo {
    public static void main(String[] args) throws Exception{
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t 国，被灭了");
                countDownLatch.countDown();
            }, CountryEnum.forEach_CountryEnum(i).getReturnMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 秦统一华夏");
        System.out.println();
        System.out.println(CountryEnum.ONE);
        System.out.println(CountryEnum.ONE.getRetCode());
        System.out.println(CountryEnum.ONE.getReturnMessage());
    }

    public static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t上完自习");
                countDownLatch.countDown();
            }, String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName() + "\t 最后关门走人");
    }
}
