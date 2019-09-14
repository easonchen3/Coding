package 笔试.笔试58;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-12 21:03
 * @Version 1.0
 */
public class Main3 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map[i][j] = scanner.nextInt();
            }
        }

        System.out.println(fun(map,n,m));
       scanner.close();
    }

    private static int fun(int[][] map,int n,int m){
        int[][] tmp = new int[n][m];
        tmp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            tmp[i][0] = map[i][0] + tmp[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            tmp[0][i] = map[0][i] + tmp[0][i-1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                tmp[i][j] = map[i][j] + Math.max(tmp[i-1][j],tmp[i][j-1]);
            }
        }
        return tmp[n-1][m-1];
    }
}
