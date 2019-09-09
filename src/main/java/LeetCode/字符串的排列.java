package LeetCode;

import java.util.ArrayList;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 12:42
 * @Version 1.0
 */
public class 字符串的排列 {
    public static void main(String[] args){
        字符串的排列 test = new 字符串的排列();
        ArrayList<String> abc = test.Permutation("aa");
        for (String s : abc) {
            System.out.println(s);
        }
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        fun(str.toCharArray(),0,res);
        return res;
    }

    public void fun(char[] str,int start,ArrayList res){
        if(str == null || start<0 || start>str.length){
            return ;
        }
        if(start == str.length-1 && !res.contains(new String(str))){
            res.add(new String(str));
        }else{
            for (int i = start; i < str.length; i++) {
                swap(str,start,i);
                fun(str,start+1,res);
                swap(str,start,i);
            }
        }
    }

    public void swap(char[] arr,int i,int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
