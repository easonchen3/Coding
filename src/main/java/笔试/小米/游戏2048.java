package 笔试.小米;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-11 20:09
 * @Version 1.0
 */
public class 游戏2048 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = scanner.nextInt();
            }
        }
        solution(map,n);
        scanner.close();
    }

    static void solution(int[][] map,int n) {

        delete(map,n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(map[i]).replaceAll("\\[|\\]|,","").trim());
        }
    }
    static void delete(int[][] map,int n){
        if(n <= 1){
            return ;
        }
        for (int i = 0; i < n; i++) {
            remove(map[i],n);
        }
    }
    static void remove(int[] a,int n){
        removeZero(a,n);
        for (int i = 0; i < n - 1; i++) {
            if(a[i]!=0 && a[i] == a[i+1]){
                a[i]*=2;
                //合并方块
                a[i+1] = 0;
            }
        }
        removeZero(a,n);
    }
    static void removeZero(int[] a,int n){
        int p = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] != 0){
                a[p++] = a[i];
            }
        }
        while(p < n){
            a[p] = 0;
            p++;
        }
    }
}