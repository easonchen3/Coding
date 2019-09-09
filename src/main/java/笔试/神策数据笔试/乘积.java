package 笔试.神策数据笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-30 09:53
 * @Version 1.0
 */
public class 乘积 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        String[] split = s.split(" ");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        System.out.println(fun(x,arr));
        scanner.close();
    }

    public static int fun(int x,int[] arr){
        if(arr == null || arr.length <= 1){
            return -1;
        }
        Arrays.sort(arr);
        if(arr[0] == x){
            return 1;
        }
        if(x == 1){
            return -1;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                continue;
            }
            while(x%arr[i] == 0){
                x /= arr[i];
            }
        }
        return x==1 ? 1 : -1;
    }
}
