import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-22 08:20
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int num = scanner.nextInt();
       while((num --) > 0){
           int n = scanner.nextInt();
           int m = scanner.nextInt();
           int[] arr = new int[n];
           for (int i = 0; i < n; i++) {
               arr[i] = scanner.nextInt();
           }
           int[] fun = fun(arr, m);
           for (int i = 0; i < n - 1; i++) {
               System.out.print(fun[i]+" ");
           }
           System.out.println(fun[n-1]);
       }
       scanner.close();
    }

    public static int[] fun(int[] arr,int time){
        int[] res = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int tmp = time;
            int cnt = 0;
            if(arr[i] == time){
                res[i] = i;
            }else{
                tmp -= arr[i];
                int[] newArr = Arrays.copyOf(arr,i);
                Arrays.sort(newArr);
                for (int j = 0; j < i; j++) {
                    if(arr[j] == arr[i]){
                        continue;
                    }
                    if(tmp >= arr[j]){
                        tmp -= arr[j];
                    }else{
                        cnt++;
                    }
                }
                res[i] = cnt;
            }
        }
        return res;
    }
}
