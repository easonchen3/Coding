package 笔试.趋势科技笔试;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-08 18:53
 * @Version 1.0
 */
import java.util.Scanner;

public class Main {
    private static int process(int[] coins,int sum) {
        int[] v = {1,5,10,20,50,100};
        long ans1 = 0,ans2 = 999;
        long t = Math.min(sum/v[5],coins[5]);
        ans1 = t;
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] num1 = new int[6];
        for (int i = 0; i < 6; i++) {
            num1[i] = sc.nextInt();
        }
        int m = sc.nextInt();

        System.out.println();
    }
}