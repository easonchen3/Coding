package 笔试.度小满;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-15 19:42
 * @Version 1.0
 */
public class 穿越障碍物 {

    private static int sum = 0;

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int x = scanner.nextInt();
       int y = scanner.nextInt();
       int n = scanner.nextInt();
       int[][] map = new int[100][100];
        for (int i = 0; i < n; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            map[a][b] = 1;
        }

        fun(0,0,x,y,map);
        System.out.println(sum);
       scanner.close();
    }

    static void fun(int x,int y,int a,int b,int[][] map){
        if(x == a && y == b){
            return;
        }
        sum++;
        if(map[x+1][y] == 1){
            fun(x,y+1,a,b,map);
        }
        if(map[x][y+1] == 1){
            fun(x+1,y,a,b,map);
        }
        if(map[x-1][y] == 1){
        }

    }


}
