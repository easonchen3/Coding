package com.baiguo.other.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author HP
 */
public class Foo {

    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public volatile int flag = 1;

    public Foo() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try{
            while(flag!=1){
                condition1.await();
            }
            printFirst.run();
            flag++;
            condition2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        // printFirst.run() outputs "first". Do not change or remove this line.

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try{
            while(flag!=2){
                condition2.await();
            }
            printSecond.run();
            flag++;
            condition3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.

    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try{
            while(flag!=3){
                condition2.await();
            }
            printThird.run();
            flag++;
            condition1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
        // printThird.run() outputs "third". Do not change or remove this line.

    }



}
