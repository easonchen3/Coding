package com.baiguo.other.Test;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-03 22:52
 * @Version 1.0
 */
public class SingletonDemo {

    private static volatile SingletonDemo instance = null;

    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"\t 我是构造方法");
    }

    /**
     *  DCL(Double Check Lock 双端检索机制)
     * @return
     */
    public static  SingletonDemo getInstance(){
        if(instance == null){
            synchronized(SingletonDemo.class){
                if(instance == null){
                    instance = new SingletonDemo();
                    //volatile避免指令重排
                }
            }
        }
        return instance;
    }

    public static void main(String[] args){
        //并发进行操作
        for(int i = 1; i <= 20; i++){
            new Thread(()->{
                SingletonDemo.getInstance();
            }, String.valueOf(i)).start();
        }
    }
}
