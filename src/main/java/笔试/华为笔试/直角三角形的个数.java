package 笔试.华为笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-28 19:02
 * @Version 1.0
 */
public class 直角三角形的个数 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int p = scanner.nextInt();
        System.out.println(fun(p));
        scanner.close();
    }

    public static int fun(int p){
        int sum = 0;
        for (int i = 1; i < p / 3; i++) {
            for (int j = i; j < p / 2; j++) {
                int k = p-i-j;
                if(k < i+j && i*i+j*j == k*k){
                    sum++;
                }
            }
        }
        return sum;
    }
}
