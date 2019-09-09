package 剑指offer;

import java.util.Arrays;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 12:55
 * @Version 1.0
 */
public class 数组中出现次数超过一半的数字 {
    public static void main(String[] args){

    }

    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        int len = array.length,cnt = 0;
        for (int i = 0; i < len; i++) {
            if(array[len/2] == array[i]) cnt++;
        }

        return (cnt>(array.length)/2)?array[len/2]:0;
    }
}
