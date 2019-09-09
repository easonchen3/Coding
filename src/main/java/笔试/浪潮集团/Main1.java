package 笔试.浪潮集团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 石头
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 131072KB；其他语言 655360KB
 题目描述：
 沙滩按照线型摆放着n个大小不一的球形石头，已知第i个石头的半径为ri，且不存在两个石头有相同的半径。
 为了使石头的摆放更加美观，现要求摆放的石头的半径从左往右依次递增。
 因此，需要对一些石头进行移动，每次操作可以选择一个石头，并把它放在剩下n−1个石头在最左边或最右边。
 问最少需要操作多少次才能将这n个石头的半径变成升序？

 最长递增子序列问题
 * @Author: BaoJian.Xu
 * @Date: 2019-08-22 13:54
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args) {

        Scanner in = new Scanner((System.in));
        int n = in.nextInt();
        int[] arr = new int[n];
        int[] sortArr = new int[n];
        for (int i = 0; i < n; i++) {

            arr[i] = in.nextInt();
            sortArr[i] = arr[i];
        }
        in.close();
        /*Arrays.sort(sortArr);
        int count = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {

            if (arr[i] == sortArr[j]) {
                ++count;
                ++j;
            }
        }
        System.out.println(n - count);*/
        System.out.println(n-fun(arr));
    }
    public static int fun(int[] arr){
        if(arr == null || arr.length <= 1){
            return 0;
        }
        int temp = arr[0];
        int cnt = 1,max = 1;
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] >= temp){
                cnt++;
            }else{
                cnt = 1;
            }
            temp = arr[i];
            if(cnt > max){
                max = cnt;
            }
        }
        return max;
    }
}
