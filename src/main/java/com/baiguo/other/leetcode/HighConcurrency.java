package com.baiguo.other.leetcode;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-22 18:48
 * @Version 1.0
 */
class MyThread extends Thread{
    @Override
    public void run() {
        try{
           int sencondeValue = (int)(Math.random()*3000);
            System.out.println(sencondeValue);
            Thread.sleep(sencondeValue);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
public class HighConcurrency {
    public static void main(String[] args){
        List<Integer> intList = new LinkedList<Integer>();
        for (int i = 1; i <= 1000000; i++) {
            intList.add(i);
        }

        Instant begin,end;

        begin = Instant.now();
        intList.stream().forEach(i->{
            i.intValue();
        });
        end = Instant.now();
        System.out.println(Duration.between(begin,end).toMillis());

        begin = Instant.now();
        intList.parallelStream().forEach(i->{
            i.intValue();
        });
        end = Instant.now();
        System.out.println(Duration.between(begin,end).toMillis());

        begin = Instant.now();
        for (Integer i : intList) {
            i.intValue();
        }
        end = Instant.now();
        System.out.println(Duration.between(begin,end).toMillis());

    }
}
