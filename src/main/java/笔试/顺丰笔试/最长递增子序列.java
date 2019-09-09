package 笔试.顺丰笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-29 19:33
 * @Version 1.0
 */
public class 最长递增子序列 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        System.out.println(findLongest(arr));
        scanner.close();
    }
    public static int findLongest(int[] arr){
        int n = arr.length;
        int[] mid = new int[n];
        for (int i = 0; i < n; i++) {
            mid[i] = Integer.MAX_VALUE;
        }
        int end = 0;
        for (int i = 0; i < n; i++) {
            int temp = binary(mid,i,arr[i]);
            mid[temp] = arr[i];
            end = temp>end?temp:end;
        }
        return end+1;
    }

    public static int binary(int[] arr,int n,int key){
        int first = 0,last = n;
        while(first<last){
            int mid = first+(last-first)/2;
            if(arr[mid] < key){
                first = mid+1;
            }else{
                last = mid;
            }
        }
        return first;
    }



    /*public static int fun(int[] arr){
        int n = arr.length;
        int[] b = new int[n+1];
        b[1] = arr[0];
        int len = 0,index;
        for (int i = 0; i < n; i++) {
            if(arr[i] >= b[i]){
                len++;
                b[len] = arr[i];
            }else{
                index = search(1,len,b,arr[i]);
                b[index] = arr[i];
            }
        }
        return len;
    }

    public static int search(int start,int end,int[] a,int target){
        int mid;
        while(start<end){
            mid = (start+end)/2;
            if(target>=a[mid]){
                start = mid+1;
            }else{
                end = mid;
            }
        }
        return start;
    }*/
}
