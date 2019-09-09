package LeetCode;

import java.util.Arrays;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-07 17:53
 * @Version 1.0
 */
public class 插入排序 {

    public static void main(String[] args){
       int[] array = new int[]{2,1,1,2,6,4,3};
       sort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array){
        for (int i = 1; i <array.length; i++) {
            if(array[i] < array[i-1]){
                int temp = array[i];
                int j = i-1;
                while(j>=0 && temp < array[j]){
                    array[j+1] = array[j];
                    j--;
                }
                array[j+1] = temp;
            }
        }
    }

    public static void insertSort(int[] arr) {
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                temp = arr[i];
                int j = 0;
                for (j = i - 1; j >= 0 && temp < arr[j]; j--) {
                    arr[j+1]=arr[j];
                }
                arr[j+1]=temp;
            }
        }
    }
}
