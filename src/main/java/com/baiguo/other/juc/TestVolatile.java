package com.baiguo.other.juc;

import java.util.concurrent.TimeUnit;

/**
 * 1.volatile关键字：当多个线程进行数据共享时候，可以保证内存中的数据可见
 *                  相较于Synchronized是一种较为轻量级的同步策略
 *   注意：
 *      1.volatile 不具备互斥性
 *      2.没有原子性
 * @Author: BaoJian.Xu
 * @Date: 2019-07-30 19:14
 * @Version 1.0
 */
public class TestVolatile {
    public static void main(String[] args){
       ThreadDemo td = new ThreadDemo();
       new Thread(td).start();

       while(true){
           if(td.isFlag()){
               System.out.println("------------");
               break;
           }
       }
    }

}

class ThreadDemo implements Runnable{

    private volatile boolean flag = false;

    @Override
    public void run() {
        try{ TimeUnit.MICROSECONDS.sleep(200);} catch(InterruptedException e){e.printStackTrace(); }
        flag = true;
        System.out.println("flag = "+isFlag());
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}