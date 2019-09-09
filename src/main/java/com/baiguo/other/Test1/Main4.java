package com.baiguo.other.Test1;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-14 15:35
 * @Version 1.0
 */

import java.util.Scanner;

public class Main4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int[] result = null;
        if(x < y){
            result = fun(x,y);
        }else {
            result = fun(y,x);
        }
        if(result == null){
            System.out.println("NO");
        }else {
            System.out.println("YES");
            System.out.println(result[0]+" "+result[1]+" "+result[2]);
        }
    }

    private static int[] fun(int x, int y) {
        int[] result = new int[3];
        if(y - x < 2 || x == y || x < 1 || y < 1){
            return null;
        } else if(x == 1 && y == 3){
            return null;
        }else if(x > 1){
            result[0] = x;
            result[1] = x+1;
            result[2] = x+2;
            return result;
        }else {
            if(y - x == 2){
                return null;
            }else {
                result[0] = x+1;
                result[1] = x+2;
                result[2] = x+3;
                return result;
            }
        }
    }
}
