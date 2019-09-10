package LeetCode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-10 15:39
 * @Version 1.0
 */
public class 买卖股票 {
    public static void main(String[] args){

    }

    private static int maxProfit(int[] prices){
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] < min){
                min = prices[i];
            }
            if((prices[i] - min) > max){
                max = prices[i] - min;
            }
        }
        return max;
    }
}
