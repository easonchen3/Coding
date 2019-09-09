package 剑指offer;

import java.util.ArrayList;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 13:02
 * @Version 1.0
 */
public class 最小的K个数 {
    
    public static void main(String[] args){
        最小的K个数 test = new 最小的K个数();
        ArrayList<Integer> integers = test.GetLeastNumbers_Solution(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4);
        for (Integer integer : integers) {
            System.out.print(integer+"\t");
        }
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if(input == null || k==0 || k>input.length){
            return new ArrayList<>();
        }
        ArrayList<Integer> res = new ArrayList<>();
        int start = 0;
        int end = input.length-1;
        int mid = pation(input,start,end);
        while(mid != (k-1)){
            if(mid > (k-1)){
                mid = pation(input,start,mid-1);
            }else{
                mid = pation(input,mid+1,end);
            }
        }
        for (int i = 0; i <= mid; i++) {
            res.add(input[i]);
        }
        return res;
    }

    public int pation(int[] input,int i,int j){
        int low = i,high = j;
        int key = input[low];
        while(low<high){
            while(input[high] >= key && low<high) high--;
            input[low] = input[high];
            while(input[low] <= key && low<high) low++;
            input[high] = input[low];
        }
        input[low] = key;
        return low;
    }
}
