package LeetCode;

import java.util.Arrays;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-03 20:45
 * @Version 1.0
 */
public class 堆排序 {
    public static void main(String[] args){
        堆排序 test = new 堆排序();
        int[] sort = test.sort(new int[]{1, 3, 2, 1, 2, 3, 44, 22});
        System.out.println(Arrays.toString(sort));
    }

    private int[] sort(int[] array){
        int[] arr = Arrays.copyOf(array,array.length);
        int len = arr.length;
        buildMaxHeap(arr,len);
        for (int i = len-1; i >=0 ; i--) {
            swap(arr,0,i);
            len--;
            heapify(arr,0,len);
        }
        return arr;
    }

    private void buildMaxHeap(int[] arr,int len){
        for (int i = (int)Math.floor(len/2); i >=0 ; i--) {
            heapify(arr,i,len);
        }
    }

    private void heapify(int[] arr,int i,int len){
        int left = i*2+1;
        int right = i*2+2;
        int largest = i;
        if(left < len && arr[left] > arr[largest]){
            largest = left;
        }
        if(right < len && arr[right] > arr[largest]){
            largest = right;
        }
        if(largest!=i){
            swap(arr,i,largest);
            heapify(arr,largest,len);
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
