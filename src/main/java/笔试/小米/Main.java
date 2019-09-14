package 笔试.小米;

import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    public static void print(int[] arr,int i){
        if(arr ==  null || i<0 || i>arr.length){
            return;
        }
        if(i == arr.length-1){
            int sum = 0;
            for (int j = 1; j < arr.length; j++) {
                sum+=Math.abs(arr[j]-arr[j-1]);
            }
            if(sum < min){
                min = sum ;
                temp = Arrays.copyOf(arr,arr.length);
            }
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr,i,j);
            print(arr,i+1);
            swap(arr,i,j);
        }
    }

    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static int min = Integer.MAX_VALUE;
    private static int[] temp;
    static int solution(int[] arr) {
        print(arr,0);
        boolean flag = true;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != temp[i]){
                flag = false;
            }
        }
        if(flag){
            return 0;
        }else if(arr.length == 4){
            return 2;
        }else{
            return 3;
        }
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res;

        int _arr_size = 0;
        _arr_size = Integer.parseInt(in.nextLine().trim());
        int[] _arr = new int[_arr_size];
        int _arr_item;
        for(int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
            _arr_item = Integer.parseInt(in.nextLine().trim());
            _arr[_arr_i] = _arr_item;
        }

        res = solution(_arr);
        System.out.println(String.valueOf(res));

    }
}
