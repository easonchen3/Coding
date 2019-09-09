package 笔试.京东笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 20:30
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){

            }else{
                count ++;
            }
        }
        System.out.println(count);
    }
}
