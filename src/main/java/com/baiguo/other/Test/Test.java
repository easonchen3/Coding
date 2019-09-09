package com.baiguo.other.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-27 23:55
 * @Version 1.0
 */
class ShareData {
    int maxLength;
    private List<Object> list;
    private Lock lock = new ReentrantLock();
    private Condition full = lock.newCondition();
    private Condition empty = lock.newCondition();

    public ShareData(int maxLength, List<Object> list) {
        this.maxLength = maxLength;
        this.list = list;
    }

    void put(Object product) {
        lock.lock();
        try {
            while (list.size() == maxLength) {
                full.await();
            }
            list.add(product);
            empty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    Object pop() {
        lock.lock();
        try {
            while (list.isEmpty()) {
                empty.await();
            }
            Object product = list.remove(0);
            full.signalAll();
            return product;
        } catch (Exception e) {
            e.printStackTrace();
            return "出错";
        } finally {
            lock.unlock();
        }

    }
}

public class Test {

    public static void main(String[] args) {
        ShareData shareData = new ShareData(5, new LinkedList<>());

        new Thread(() -> {
            while (true) {
                String name = (int) (Math.random() * 10) + "号产品";
                System.out.println("生产者生产了：" + name);
                shareData.put(name);
            }
        }, "生产者").start();

        new Thread(() -> {
            while (true) {
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Object product = shareData.pop();
                System.out.println("消费者消费了：" + product);
            }
        }, "消费者").start();
    }
}

