package 笔试.浪潮集团;

import java.util.Scanner;

/**
 *
 * 被砍掉的树
 * 被砍掉的树
 时间限制：C/C++语言 1000MS；其他语言 3000MS
 内存限制：C/C++语言 131072KB；其他语言 655360KB
 题目描述：
 某条街道两侧分别种植了一排树木，并按如下编号：

 1 3 5 7 .... 45 47 49 ... 99

 2 4 6 8 ... 46 48 50 ... 100

 但是有一些树被砍去，希望你能找出一边最长的连续的大树。
 * @Author: BaoJian.Xu
 * @Date: 2019-08-22 13:32
 * @Version 1.0
 */
public class Main2 {

    public static void main(String[] args){
        int[] nums1 = new int[51];
        int[] nums2 = new int[51];
        int i = 1;
        while(i<=100){
            if(i%2 != 0){
                nums1[(i/2)+1] = i;
            }else{
                nums2[i/2] = i;
            }
            i++;
        }

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int cnt = 0;
        for (int j = 0; j < n; j++) {
            cnt = scanner.nextInt();
            if(cnt % 2 == 0){
                nums2[cnt/2] = 0;
            }else{
                nums1[(cnt/2)+1] = 0;
            }
        }
        int max1 = 0, max2 = 0,maxi = 0,maxj = 0;
        int temp = 0;
        for (int j = 1; j < nums1.length; j++) {
            if(nums1[j]!=0){
                temp++;
            }else{
                temp = 0;
            }
            if(temp > max1){
                max1 = temp;
                maxi = j-temp;
            }
        }
        temp = 0;
        for (int j = 0; j < nums2.length; j++) {
            if(nums2[j]!=0){
                temp++;
            }else{
                temp = 0;
            }
            if(temp > max2){
                max2 = temp;
                maxj = j-temp;
            }
        }
        if(max1>max2){
            System.out.println(nums1[maxi+1]+" "+max1);
        }else{
            System.out.println(nums2[maxj+1]+" "+max2);
        }
    }
}
