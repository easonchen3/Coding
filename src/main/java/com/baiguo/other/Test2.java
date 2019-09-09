package com.baiguo.other;

import java.util.Scanner;

/**
 * 第一题
 * @Author: BaoJian.Xu
 * @Date: 2019-08-03 16:06
 * @Version 1.0
 */
public class Test2 {

    public static void main(String[] args){
       Scanner in = new Scanner(System.in);
       int n = in.nextInt();
       int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = in.nextInt();
        }
        int m = in.nextInt();
        int[] aa = new int[m];
        for (int i = 0; i < m; i++) {
            aa[i] = in.nextInt();
        }
        in.close();

        double[] result = new double[n];
        for (int i = 0; i < n; i++) {
            result[i] = (double)(getResult(array,array[i-1])/n*100);
        }
        for (int i = 0; i < m; i++) {
            double re = result[aa[i]-1];
            if (re == 0) {
                System.out.println("0.00000");
            }else{
                System.out.println(String.format("%.6f",re));
            }
        }
    }
    public static int getResult(int[] a,int num){
        int count = 0;
        for (int i : a) {
            count = i<= num?count+1:count;
        }
        return count;
    }

}
