package 剑指offer;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-25 21:20
 * @Version 1.0
 */
public class 数字在排序数组中出现的次数 {
    public static void main(String[] args) {
        数字在排序数组中出现的次数 test = new 数字在排序数组中出现的次数();
        int i = test.GetNumberOfK(new int[]{1, 2, 3, 3, 3, 4}, 3);
        System.out.println(i);
    }

    public int GetNumberOfK(int[] array, int k) {
        int mid = binarySearch(array, k, 0, array.length - 1);
        if (mid == -1) {
            return 0;
        }
        int i = mid - 1, j = mid + 1;
        int sum = 1;
        while (i > 0 && array[i] == k) {
            sum++;
            i--;
        }
        while (j < array.length && array[j] == k) {
            sum++;
            j++;
        }
        return sum;
    }

    public int binarySearch(int[] array, int k, int i, int j) {

        int mid = (i + j) >> 2;
        while (i <= j) {
            if (array[mid] < k) {
                i = mid + 1;
            } else if (array[mid] > k) {
                j = mid - 1;
            } else {
                return mid;
            }
            mid = (i+j)>>2;
        }
        return -1;
    }
}
