package 笔试.疯狂游戏;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-19 19:11
 * @Version 1.0
 */
public class 查找序列 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int n = Integer.valueOf(split[0]);
        String[] split1 = split[1].split(",");
        int[] arr = new int[split1.length];
        for (int i = 0; i < split1.length; i++) {
            arr[i] = Integer.valueOf(split1[i]);
        }
        fun(arr,n);
        scanner.close();
    }

    public static void fun(int[] arr,int n){
        int a = -1,b = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == n){
                a = i;
                break;
            }
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i] == n){
                b = i;
                break;
            }
        }
        System.out.println(a+","+b);
    }

}
