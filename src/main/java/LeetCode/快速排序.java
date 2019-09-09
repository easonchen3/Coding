package LeetCode;

import java.util.Arrays;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-07 18:09
 * @Version 1.0
 */
public class 快速排序 {

    public static void main(String[] args){
       int[] arr = new int[]{2,3,1,5,3,1,2};
        sortQuick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void sortQuick(int[] arr,int i,int j){
        if(i<j){
            int potion = pation(arr,i,j);
            sortQuick(arr,i,potion-1);
            sortQuick(arr,potion+1,j);
        }
    }

    public static int pation(int[] arr,int i,int j){
        int temp = arr[i];
        while(i<j){
            while(i<j && arr[j]>=temp) j--;
            arr[i] = arr[j];
            while(i<j && arr[i]<=temp) i++;
            arr[j] = arr[i];
        }
        arr[i] = temp;
        return i;
    }
}
