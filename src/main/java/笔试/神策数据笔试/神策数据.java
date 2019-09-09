package 笔试.神策数据笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-30 10:12
 * @Version 1.0
 */
public class 神策数据 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }


        System.out.println(fun(a, b));
        scanner.close();
    }


    public static int fun(int[] a, int[] b) {
        if(a == null || b == null || a.length == 0 || b.length == 0){
            return 0;
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int i = 0, j = 0;
        int cnt = 0;
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                cnt++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return cnt;
    }
}
