package 笔试.VIPKID笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-03 16:40
 * @Version 1.0
 */
public class 寻找Zero组数 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s= scanner.nextLine();
       s = s.replaceAll(" ","");
        String[] split = s.split(",");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }
        System.out.println(fun(arr));
        scanner.close();
    }

    public static int fun(int[] arr){
        Arrays.sort(arr);
        int cnt = 0;
        int i = 0,j = arr.length-1;
        while(i<j){
            if(arr[i] + arr[j] == 0){
                cnt++;
                i++;
                j--;
            }else if(arr[i] + arr[j] > 0){
                j--;
            }else{
                i++;
            }
        }
        return cnt;
    }


}
