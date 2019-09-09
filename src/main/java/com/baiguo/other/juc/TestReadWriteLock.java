package com.baiguo.other.juc;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 * 1. ReadWriteLock 读写锁
 * 写写/读写 是需要互斥的
 * 读读  是不需要互斥的
 * @Author: BaoJian.Xu
 * @Date: 2019-07-31 13:15
 * @Version 1.0
 */
public class TestReadWriteLock {
    public static void main(String[] args){
        ReadWriteLockDemo rw = new ReadWriteLockDemo();
        new Thread(() -> {
            rw.set((int) (Math.random()*101));
        },"Write").start();

        for(int i = 1; i <= 100; i++){
            new Thread(()->{
                rw.get();
            }, String.valueOf(i)).start();
        }
    }
}
class ReadWriteLockDemo{
    private int num = 0;
    
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    
    //读
    public void get(){
        lock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+":"+num);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.readLock().unlock();
        }
    }
    
    public void set(int num){
        lock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName());
            this.num = num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.writeLock().unlock();
        }
    }
}