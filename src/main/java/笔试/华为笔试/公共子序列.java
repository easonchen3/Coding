package 笔试.华为笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-28 19:20
 * @Version 1.0
 */
public class 公共子序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String A = scanner.nextLine();
        String B = scanner.nextLine();
        scanner.close();


        System.out.println(n - fun(A.replaceAll(" ", ""), B.replaceAll(" ", ""), n));
    }

    private static int fun(String A, String B, int n) {
        int[][] c = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                } else {
                    c[i][j] = Math.max(c[i - 1][j], c[i][j - 1]);
                }
            }
        }
        return c[n][n];
    }
}
