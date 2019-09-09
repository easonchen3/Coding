package com.baiguo.other.thread;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class MyCache{ //资源类
    private volatile Map<String,Object> map = new HashMap<>();
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    public  void put(String key,Object value){
        rwLock.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
            try{ TimeUnit.MILLISECONDS.sleep(300);} catch(InterruptedException e){e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t 写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public  void get(String key){

        rwLock.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"\t 正在读取：");
            try{ TimeUnit.MILLISECONDS.sleep(300);} catch(InterruptedException e){e.printStackTrace(); }
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+o);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }


    public void clearMap(){
        map.clear();
    }


}
/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-18 16:48
 * @Version 1.0
 *
 *
 *
 *   读-读能共享
 *   读-写不可能共享
 *   写-写不可能共享
 *
 *   写操作：原子+独占 整个过程必须是一个完整的
 */
public class ReadWriteLockDemo {
    public static void main(String[] args){
        MyCache cache = new MyCache();

        for(int i = 1; i <= 5; i++){
            final int tempInt = i;
            new Thread(()->{
                cache.put(tempInt+"",tempInt+"");
            }, String.valueOf(i)).start();
        }

        for(int i = 1; i <= 5; i++){
            final int tempInt = i;
            new Thread(()->{
                cache.get(tempInt+"");
            }, String.valueOf(i)).start();
        }
    }
}
