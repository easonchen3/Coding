package 笔试.VIPKID笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-03 16:38
 * @Version 1.0
 */
public class 整数二进制 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
        System.out.println(fun(n));
       scanner.close();
    }

    public static int fun(int n){
        int cnt = 0;
        while(n!=0){
            n = n &(n-1);
            cnt++;
        }
        return cnt;
    }
}
