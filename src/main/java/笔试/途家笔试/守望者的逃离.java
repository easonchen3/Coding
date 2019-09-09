package 笔试.途家笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-06 20:57
 * @Version 1.0
 */
public class 守望者的逃离 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int m = scanner.nextInt();
       int s = scanner.nextInt();
       int t = scanner.nextInt();
       int a = 0,b=0;
        for (int i = 1; i <= t; i++) {
            a+=13;
            if(m >= 10){
                m-= 10;
                b+=50;
            }
            else{
                m+=4;
            }
            a = Math.max(a,b);
            if(a >= s){
                System.out.println("Yes "+i);
                return ;
            }
        }
        System.out.println("No "+a);
       scanner.close();
    }
}
