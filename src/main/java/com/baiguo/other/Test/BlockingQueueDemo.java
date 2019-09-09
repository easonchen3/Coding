package com.baiguo.other.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-29 16:23
 * @Version 1.0
 * <p>
 * <p>
 * <p>
 * 1.队列
 * <p>
 * 2.阻塞队列
 * 2.1 阻塞队列有没有好的一面
 * 2.2 不得不阻塞，你如何管理
 *
 * 暴力组直接抛出异常
 *      插入：add
 *      查看队首：element
 *      移除:remove
 * 成功true 失败false
 *      插入：offer
 *      查看队首：peek
 *      移除:poll
 * 失败阻塞
 *      插入：put
 *      查看队首：
 *      移除:take
 *  定时阻塞：//推荐使用
 *      插入：public boolean offer(E e, long timeout, TimeUnit unit)
 */
public class BlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        //List list = new ArrayList();
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
        System.out.println(blockingQueue.offer("a", 2L, TimeUnit.SECONDS));
    }
}
