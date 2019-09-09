package 笔试.快手笔试;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-25 17:29
 * @Version 1.0
 */
public class 好序列的个数 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       Data[][] map = new Data[n+1][n+1];
        for (Data[] data : map) {
            Arrays.fill(data,new Data(Integer.MAX_VALUE,-1));
        }
       int k = scanner.nextInt();
       int a1=0,a2=0,a3=0;
       for (int i = 0; i < n-1; i++) {
               a1 = scanner.nextInt();
               a2 = scanner.nextInt();
               a3 = scanner.nextInt();
            map[a1][a2] = new Data(1,a3);
            map[a2][a1] = new Data(1,a3);
        }
        for (Data[] data : map) {
            for (Data datum : data) {
                System.out.print(datum.value+"\t");
            }
            System.out.println();
        }
        System.out.println(n*n-n);

    }

    static class Data{
        int value;
        int flag;//1为黑色，0为红色
        Data(int value,int flag){
            this.value = value;
            this.flag = flag;
        }
    }
}
