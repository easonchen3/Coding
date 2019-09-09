package 笔试.华为笔试;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-28 19:50
 * @Version 1.0
 */
public class Main2 {
    private static int[][] arry = new int[][]{
            {1, 2, 3, 4, 5},
            {11, 12, 13, 14, 15},
            {21, 22, 23, 24, 25},
            {31, 32, 33, 34, 35},
            {41, 42, 43, 44, 45}
    };
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int data[] = new int[6];
       String line = scanner.nextLine();
       while(line!=null && !line.equals("")){
           String[] str = line.split(" ");
           for (int i = 0; i < 6; i++) {
               data[i] = Integer.valueOf(str[i]);
           }
           System.out.println(fun(data));
           line = scanner.nextLine();
       }

       scanner.close();
    }

    public static int fun(int[] data){
        HashSet<Integer> set = new HashSet<>();
        for (int datum : data) {
            set.add(datum);
        }
        byte[][] flag = new byte[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if(set.contains(arry[i][j])){
                    flag[i][j] = 1;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            int row = -1;
            for (int j = 0; j < 5; j++) {
                if(flag[i][j] == 1){
                    if(row == -1){
                        row = j;
                        continue;
                    }
                    if(j - row == 1){
                        row = j;
                        continue;
                    }else{
                        return 0;
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            boolean f = false;
            boolean has = false;
            for (int j = 0; j < 5; j++) {
                if(flag[i][j] == 1){
                    has = true;
                    if((i-1)>=0 && flag[i-1][j] == 1){
                        f = true;
                    }
                    if(i+1 <= 4 && flag[i+1][j] == 1){
                        f = true;
                    }
                }
            }
            if(has && !f){
                return 0;
            }
        }
        return 1;
    }
}
