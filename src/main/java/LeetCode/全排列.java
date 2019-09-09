package LeetCode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-20 21:26
 * @Version 1.0
 */
public class 全排列 {

    public static void main(String[] args){
       String string = "abc";
       print(string.toCharArray(),0);
    }

    public static void print(char[] arr,int i){
        if(arr ==  null || i<0 || i>arr.length){
            return;
        }
        if(i == arr.length-1){
            System.out.print(new String(arr)+"\t");
        }
        for (int j = i; j < arr.length; j++) {
            swap(arr,i,j);
            print(arr,i+1);
            swap(arr,i,j);
        }
    }

    private static void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
