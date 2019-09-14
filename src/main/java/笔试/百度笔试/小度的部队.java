package 笔试.百度笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-10 20:43
 * @Version 1.0
 */
public class 小度的部队 {

    private static int x = 0;

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int a= scanner.nextInt();
        int b = scanner.nextInt();
        fun(a,b);
        System.out.println(x);
        scanner.close();
    }

    public static void fun(int a,int b){
        int len = a -b;
        if(len < 2 || len%2 == 1){
            x++;
            return ;
        }
        fun(len/2,b);
        fun(len/2+b,b);
    }
}
