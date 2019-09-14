package 笔试.去哪儿;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-12 15:45
 * @Version 1.0
 */
public class 求n维数组的最大子数组 {

    private static int[][] arr ;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        int temp ;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                    }
                }
            }
        }

        System.out.println();
        scanner.close();
    }
    static int check(int i,int j){
        if(i<0 || j<0){
            return 0;
        }
        return arr[i][j];
    }
}
