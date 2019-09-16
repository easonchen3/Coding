package 笔试.招商;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-15 20:57
 * @Version 1.0
 */
public class 机器人 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s = scanner.nextLine();
        fun(s);
       scanner.close();
    }

    private static void fun(String str){
        StringBuilder sb = new StringBuilder();
        int[] res = new int[str.length()];
        Arrays.fill(res,1);
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == 'R'){
                res[i+1] += res[i];
                res[i] =0;
            }else{
                res[i]--;
                res[i-1]++;
            }
        }
        for (int i = 0; i < res.length-1; i++) {
            System.out.print(res[i]+" ");
        }
        System.out.println(res[res.length-1]);
    }
}
