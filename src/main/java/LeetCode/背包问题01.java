package LeetCode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-07 11:21
 * @Version 1.0
 */
public class 背包问题01 {



    public static void main(String[] args){
        int N = 5,w = 21;
        int[][] B = new int[N+1][w];
        int[] weights = new int[]{0,2,3,4,5,9};
        int[] values = new int[]{0,3,4,5,8,10};

        System.out.println(Knspasck(N,w,weights,values));

    }

    /**
     *
     * @param n         背包中物品的个数
     * @param w         背包中可以装东西的重量
     * @param weights   所有物品的重量
     * @param values    所有物品的价值
     * @return
     */
    public static int Knspasck(int n,int w,int[] weights,int[] values){
        int[][] dp = new int[n+1][w];
        //初始化结果集
        for (int i = 0; i < w; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < w; j++) {
                if(weights[i] > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j-weights[i]]+values[i],dp[i-1][j]);
                }
            }
        }
        return dp[n][w-1];
    }
}
