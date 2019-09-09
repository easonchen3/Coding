package com.baiguo.other.juc;

import java.util.concurrent.CountDownLatch;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-01 13:26
 * @Version 1.0
 */
public class TestCountDownLatch {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(5);
        LatchDemo ld = new LatchDemo(latch);

        long start = System.currentTimeMillis();
        for(int i = 1; i <= 5; i++){
            new Thread(ld).start();
        }
        latch.await();
        long end = System.currentTimeMillis();

        System.out.println("耗时: "+(end-start));
    }
}

class LatchDemo implements Runnable{

    private CountDownLatch latch;

    public LatchDemo(CountDownLatch latch){
        this.latch = latch;
    }

    @Override
    public void run() {
        synchronized (this){
            try{
                for (int i = 0; i < 50000; i++) {
                    if(i%2==0){
                        System.out.println(i);
                    }
                }
            }catch(Exception e){
                e.printStackTrace();
            }finally{

                latch.countDown();
            }
        }
    }
}
