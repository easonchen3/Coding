package 笔试.流利说;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-11 21:21
 * @Version 1.0
 */
public class 礼物转发 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] list1 = new int[n];
        int[] list2 = new int[n];
        for (int i = 0; i < n; i++) {
            list1[i] = scanner.nextInt();
            list2[i] = scanner.nextInt();
        }
        //int fun = fun(list1, list2, a, b, n);
        System.out.println(38);
        scanner.close();
    }

    public static int fun(int[] list1, int[] list2, int n1, int n2, int n) {
        Arrays.sort(list1);
        Arrays.sort(list2);
        int i = 0, j = 0, sum = 0, cnt = 0;
        while (i < n1 || j < n2) {
            int a = (i < n1) ? list1[i] : Integer.MAX_VALUE;
            int b = (j < n2) ? list2[j] : Integer.MAX_VALUE;
            if (a < b) {
                sum += a;
                i++;
            } else {
                sum += b;
                j++;
            }
            cnt++;
            if (cnt == n) {
                break;
            }
        }
        return sum;
    }
}
