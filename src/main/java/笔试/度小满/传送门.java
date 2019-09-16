package 笔试.度小满;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-15 19:49
 * @Version 1.0
 */
public class 传送门 {
    public static void main(String[] args){
        Map<Integer,Integer> map = new HashMap<>();
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int key = arr[arr.length-1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == key){
                index = i;
                break;
            }
        }
        System.out.println(2*a+(arr[0]-index)*b);
       scanner.close();
    }

}
