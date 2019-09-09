package com.baiguo.other.juc;

/**
 *
 * 模拟CAS算法
 * @Author: BaoJian.Xu
 * @Date: 2019-08-01 13:04
 * @Version 1.0
 */
public class TestCompareAndSwap {
    public static void main(String[] args){
        final CompareAndSwap cas = new CompareAndSwap();

       for(int i = 1; i <= 10; i++){
           new Thread(()->{
               int expectedValue = cas.get();
               boolean b = cas.compareAndSet(expectedValue, (int) (Math.random() * 101));
               System.out.println(b);
           }, String.valueOf(i)).start();
       }
    }
}


class CompareAndSwap{
    private int value;

    public synchronized int get(){
        return value;
    }

    public synchronized int compareAndSwap(int expectedValue,int newValue){
        int oldValue = get();

        if(oldValue == expectedValue){
            this.value = newValue;
        }
        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue,int newValue){
        return expectedValue == compareAndSwap(expectedValue,newValue);
    }

}