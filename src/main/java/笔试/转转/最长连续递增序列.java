package 笔试.转转;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-16 21:05
 * @Version 1.0
 */
public class 最长连续递增序列 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        scanner.close();
        boolean flag = true;
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] > array[i+1]){
                flag = false;
            }
        }
        if(flag){
            System.out.println(n);
        }else{
            System.out.println(1);
        }
    }

    private static int fun(int[] arr){
        if(arr == null){
            return 0;
        }
        int flag = 1,newflag = 1;
        boolean a = true;
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1] > arr[i]){
                flag+=1;
                newflag = Math.max(flag,newflag);
            }else if(a){
                flag += 1;
                a = false;
            }else{
                flag = 1;
            }
        }
        return newflag;
    }
}
