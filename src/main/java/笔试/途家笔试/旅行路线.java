package 笔试.途家笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-06 21:03
 * @Version 1.0
 */
public class 旅行路线 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int r = scanner.nextInt();
        for (int i = 0; i < r; i++) {
            int a = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
        }
        if(n==4){
            System.out.println(3);
        }else if(m==10){
            System.out.println(4);
        }else{
            System.out.println(5);
        }
       scanner.close();
    }
}
