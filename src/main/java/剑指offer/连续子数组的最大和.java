package 剑指offer;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 13:30
 * @Version 1.0
 */
public class 连续子数组的最大和 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if(sum > 0) sum+=array[i];
            else    sum = array[i];
            if(sum > max) max = sum;
        }
        return max;
    }
}
