package LeetCode;

import java.util.Arrays;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-07 18:40
 * @Version 1.0
 */
public class 归并排序 {
    public static void meger(int[] arr, int L, int M, int R) {

        int p1 = L,p2=M+1,k=L;
        int[] temp = new int[arr.length];

        while(p1<=M && p2<=R){
            if(arr[p1]<arr[p2]){
                temp[k++] = arr[p1++];
            }else{
                temp[k++] = arr[p2++];
            }
        }
        while(p1<=M){
            temp[k++] = arr[p1++];
        }
        while(p2<=R){
            temp[k++] = arr[p2++];
        }
        //复制回原来的数组里
        System.arraycopy(temp,L,arr,L,R-L+1);

        /*for (int i = L; i <= R; i++) {
            arr[i] = temp[i];
        }*/
    }

    public static void megerSort(int[] arr, int L, int R) {
        if(L < R){
            int M = (L+R)/2;
            megerSort(arr,L,M);
            megerSort(arr,M+1,R);
            meger(arr,L,M,R);
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,1,5,2,3,12312,22,11,22,0};
        megerSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));


    }

}
