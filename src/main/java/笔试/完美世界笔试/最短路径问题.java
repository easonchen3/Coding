package 笔试.完美世界笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-23 19:22
 * @Version 1.0
 */
public class 最短路径问题 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[][] map = new int[7][7];
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                int temp = scanner.nextInt();
                if(temp == -1){
                    temp = Integer.MAX_VALUE;
                }
                map[i][j] = temp;
            }
        }
        int[] res = new int[7];
        int[] book = new int[7];
        for (int i = 1; i < 7; i++) {
            res[i] = map[1][i];
            book[i] = 0;
        }
        book[1] = 1;
        
        int min;
        int  u = 0;
        int inf = Integer.MAX_VALUE;
        for (int i = 1; i <7 ; i++) {
            min = inf;
            for (int j = 1; j < 7; j++) {
                if(book[j] == 0 && res[j] < min){
                    min = res[j];
                    u = j;
                }
            }
            book[u] = 1;
            for (int j = 1; j < 7; j++) {
                if(map[u][j] < inf){
                    if(res[j] > res[u]+map[u][j]){
                        res[j] = res[u]+map[u][j];
                    }
                }
            }
        }
        for (int i = 2; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

}
