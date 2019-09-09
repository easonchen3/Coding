package com.baiguo.other.juc;

import java.util.concurrent.RecursiveTask;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-31 18:21
 * @Version 1.0
 */
public class TestForkJoinPool {
}

class ForkJoinSumCalculate extends RecursiveTask<Long>{

    private long start;
    private long end;

    private static final long THURESHOLD = 0L;

    @Override
    protected Long compute() {
        return null;
    }
}
