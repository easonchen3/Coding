package com.baiguo.other.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/** CAS 算法保证数据的原子性
 *  Compare-And-Swap
 *      CAS算法是硬件对于并发操作共享数据的支持
 *      CAS包含三个操作数
 *          内存值V
 *          预估值A
 *          更新值B
 *          当且仅当V==A时。V=B 否则将不做任何操作
 * @Author: BaoJian.Xu
 * @Date: 2019-08-01 12:44
 * @Version 1.0
 */
public class TestAtomicDemo {

    public static void main(String[] args) {
        AutomicDemo ad = new AutomicDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(ad).start();
        }
    }
}

class AutomicDemo implements Runnable {

    //private int serialNumber = 0;
    private AtomicInteger serialNumber = new AtomicInteger();

    @Override
    public void run() {
        try {
            TimeUnit.MICROSECONDS.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getSerialNumber());
    }

    public int getSerialNumber() {
        return serialNumber.getAndIncrement();
    }
}
