package LeetCode;


/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-03 13:11
 * @Version 1.0
 */
public class 循环有序数组查找值 {

    public static int sortArrFind(int[] arr,int low,int high,int target){
        int mid = (low+high)/2;
        if(arr[mid] == target) return mid;
        if(arr[mid] < arr[high]){
            if(arr[mid] < target && target <= arr[high]){
                return BinaryFind(arr,mid,high,target);
            }else{
                return sortArrFind(arr,low,mid,target);
            }
        }else{
            if(arr[mid] > target && target >= arr[low]){
                return BinaryFind(arr,low,mid,target);
            }else{
                return sortArrFind(arr,mid,high,target);
            }
        }
    }

    public static int BinaryFind(int[] arr,int low,int high,int target){
        int mid = (low+high)/2;
        if(arr[mid] == target) return mid;
        if(arr[mid] < target){
            return BinaryFind(arr,mid+1,high,target);
        }else{
            return BinaryFind(arr,low,mid-1,target);
        }
    }
    public static void main(String[] args){

       int[] arr = {6,7,8,9,1,2,3,4,5};
        System.out.println(sortArrFind(arr,0,arr.length-1,8));
        System.out.println(sortArrFind(arr,0,arr.length-1,1));
        System.out.println(sortArrFind(arr,0,arr.length-1,5));
        System.out.println(sortArrFind(arr,0,arr.length-1,6));
    }
}
