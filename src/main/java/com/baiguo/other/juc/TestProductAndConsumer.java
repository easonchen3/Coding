package com.baiguo.other.juc;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-01 13:53
 * @Version 1.0
 */
public class TestProductAndConsumer {
    public static void main(String[] args){
       Clerk clerk = new Clerk();
       Productor productor = new Productor(clerk);
       Consumer consumer = new Consumer(clerk);
       
       new Thread(productor,"生产者A").start();
       new Thread(consumer,"消费者B").start();


    }
}

class Clerk{
    private int product = 0;

    public synchronized void get(){
        while(product>=10){
            System.out.println("产品已满");

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+ ++product);
        this.notifyAll();
    }

    public synchronized void sale(){
        while(product<=0){
            System.out.println("缺货");

            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+" : "+ --product);
        this.notifyAll();
    }
}

class Productor implements Runnable{
    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }


    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.get();
        }
    }
}

class Consumer implements Runnable{

    private Clerk clerk;

    public Consumer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            clerk.sale();
        }
    }
}
