package com.baiguo.other.Test1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-17 19:26
 * @Version 1.0
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        sc.close();
        //以最小值为基准，按序左右插入即可
        // 发现只有第一个元素和最后一个元素与相邻元素相邻，其他均间隔2
        Arrays.sort(a);
        int max = Math.max(a[1] - a[0], a[n - 1] - a[n - 2]);
        for (int i = 0; i + 2 < n; i++) {
            max = Math.max(a[i + 2] - a[i], max);
        }
        System.out.println(max);
    }
}
