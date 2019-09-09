package com.baiguo.other.leetcode;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-17 15:35
 * @Version 1.0
 */
public class 交替打印 {

}
class FooBar{
    private int n;
    private volatile boolean flag = true;

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while(!flag){
                Thread.yield();
            }
            printFoo.run();
            flag = false;
        }
    }

    public synchronized void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            while(flag){
                Thread.yield();
            }
            printBar.run();
            flag = false;
        }

    }
}
