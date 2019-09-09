package com.baiguo.other.Test1;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-14 14:35
 * @Version 1.0
 */
import java.util.Scanner;

public class Main2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] array = new int[n][7];
        int tmp = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 7; j++){
                array[i][j] = scanner.nextInt();
            }
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 7; j++){
                tmp += array[i][j];
            }
            System.out.println(fun(array,n,tmp));
            tmp = 0;
        }
    }
    public static int fun(int[][] array,int n,int s){
        int a1 = s/7;
        int a2 = s%7;
        int result = 1;
        for(int i = 0; i < (7-a2); i++){
            result*=a1;
        }
        for(int i = 0; i < (a2); i++){
            result*=(a1+1);
        }
        return result;
    }

}
