package 笔试.笔试58;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-12 20:41
 * @Version 1.0
 */
public class 分饼干 {

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);

       int n = scanner.nextInt();
       int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i]  = scanner.nextInt();
        }
        System.out.println(fun(arr));
       scanner.close();
    }

    private static int fun(int[] arr){
        if(arr == null || arr.length == 0){
            return 0;
        }
        if(arr.length == 1){
            return arr[0];
        }
        int sum = 0;
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = 1;
        }
        for (int i = 0; i < arr.length-1; i++) {
            if(arr[i+1] > arr[i]){
                tmp[i+1] = tmp[i]+1;
            }
        }

        for (int i = arr.length-1; i > 0 ; i--) {
            if(arr[i-1] > arr[i]){
                tmp[i-1] = Math.max(tmp[i]+1,tmp[i-1]);
            }
        }
        for (int i = 0; i < tmp.length; i++) {
            sum+=tmp[i];
        }
        return sum;
    }
}
