package com.baiguo.other.Test1;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-14 14:49
 * @Version 1.0
 */
public class Main3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int sum = 0;
        for(int i = 1;i<a;i++){
            sum+=i;
        }
        sum+=fun(a,b,1);
        System.out.println(sum);
    }
    public static int fun(int a,int b,int sum){
        if(a==1 && b==1){
            return sum;
        }
        if(b==1){
            return fun(a-1,b,sum);
        }
        if(b==a){
            return fun(a-1,b-1,sum);
        }
        return fun(a-1,b,sum/2)+fun(a-1,b-1,sum/2);
    }
}
