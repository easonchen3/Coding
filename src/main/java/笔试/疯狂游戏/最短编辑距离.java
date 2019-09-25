package 笔试.疯狂游戏;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-19 19:02
 * @Version 1.0
 */
public class 最短编辑距离 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s= scanner.nextLine();
        String[] split = s.split(" ");
        System.out.println(test(split[0],split[1]));
        scanner.close();
    }
    public static int test(String a,String b){
        if(a.equals(null) || b.equals(null)){
            return 0;
        }
        if(a == b){
            return 0;
        }
        int result = 0;
        int[][] dp = new int[a.length()+1][b.length()+1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int tmp = Math.min(dp[i][j-1]+1,dp[i-1][j]+1);
                dp[i][j] = Math.min(tmp,dp[i-1][j-1]+((a.charAt(i-1) == b.charAt(j-1)) ? 0 : 1));
                result = dp[i][j];
            }
        }
        return result;
    }
}
