package 笔试.美团笔试;

import java.util.Scanner;

/**美团骑手包裹区间分组
 *
 * 划分单独的区间，一个字母只在一个区间中出现
 * @Author: BaoJian.Xu
 * @Date: 2019-08-23 12:48
 * @Version 1.0
 */
public class Main1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            in.close();
            System.out.println(n - lengthOfLIS_02(a, n));
        }


        private static int lengthOfLIS_02(int[] nums, int numsSize) {
            if (numsSize < 2) {
                return numsSize;
            }
            int[] tmp = new int[numsSize];
            int position;
            tmp[0] = nums[0];
            int len = 1;
            for (int i = 1; i < numsSize; i++) {
                if (nums[i] > tmp[len - 1]) {
                    tmp[len] = nums[i];
                    len++;
                } else {
                    position = binarySearch(tmp, len, nums[i]);
                    tmp[position] = nums[i];
                }
            }
            return len;
        }

        private static int binarySearch(int[] array, int len, int key) {
            int low = 0;
            int high = len - 1;
            int middle;
            while (low <= high) {
                middle = low + (high - low) / 2;
                if (array[middle] > key) {
                    high = middle - 1;
                } else if (array[middle] < key) {
                    low = middle + 1;
                } else {
                    return middle;
                }
            }
            return low;
        }
}

