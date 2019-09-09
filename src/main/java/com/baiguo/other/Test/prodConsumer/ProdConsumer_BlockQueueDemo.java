package com.baiguo.other.Test.prodConsumer;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
    private volatile boolean FLAG = true; //默认开启
    private AtomicInteger atomicInteger = new AtomicInteger();

    BlockingQueue<String> blockingQueue = null;

    public MyResource(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean returnVal;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            returnVal = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
            if (returnVal) {
                System.out.println(Thread.currentThread().getName() + "\t插入" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t插入" + data + "失败");
            }
            TimeUnit.SECONDS.sleep(2);
        }
        System.out.println(Thread.currentThread().getName() + "\t线程停止，生产动作结束");
    }

    public void myConsumer() throws Exception {
        String result = null;
        while (FLAG) {
            result = blockingQueue.poll(2L, TimeUnit.SECONDS);

            if (null == result || result.equalsIgnoreCase("")) {
                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超时2秒没有取到退出");
                System.out.println();
                System.out.println();
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t消费" + result + "成功");

        }
    }

    public void stop() throws Exception {
        this.FLAG = false;
    }

}

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-30 00:13
 * @Version 1.0
 * <p>
 * volatile /CAS / atomicInteger / BlockQueue / 线程交互 / 原子引用
 */
public class ProdConsumer_BlockQueueDemo {
    public static void main(String[] args) throws Exception {
        MyResource myResource = new MyResource(new ArrayBlockingQueue<>(10));

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t生产线程启动");
            try {
                myResource.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "prod").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t消费线程启动");
            try {
                myResource.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "Consumer").start();

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("五秒钟时间到");

        myResource.stop();
    }
}
