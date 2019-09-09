package com.baiguo.other.thread;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-12 09:24
 * @Version 1.0
 */

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全问题
 * ArrayList
 */
public class ContainerNotSafeDemo {
    public static void main(String[] args){
        Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
        for(int i = 1; i <= 30; i++){
            new Thread(()->{
                map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }, String.valueOf(i)).start();
        }
    }
    

    public static void setNotSafe() {
        Set<String> set = new CopyOnWriteArraySet<>();
        for(int i = 1; i <= 30; i++){
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,8));
                System.out.println(set);
            }, String.valueOf(i)).start();
        }
        new HashSet<>().add("a");
    }


    public static void listNotSafe(){
            List<String> list = new CopyOnWriteArrayList<>();
            for(int i = 1; i <= 30; i++){
                new Thread(()->{
                    list.add(UUID.randomUUID().toString().substring(0,8));
                    System.out.println(list);
                }, String.valueOf(i)).start();

            /**
             * 1.故障
             *      ConcurrentModificationException
             *
             *
             * 2.导致原因
             *
             * 3.解决问题
             *   3.1  new Vector<>()
             *   3.2  Colletions.Synchronized(new ArrayList<>());
             *   3.3  CopyOnWriteArrayList<>()   写时复制
             *
             */
        }

    }
}
