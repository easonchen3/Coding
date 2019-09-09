package 笔试.完美世界笔试;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-23 18:48
 * @Version 1.0
 */
public class 坐船问题 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int limit = scanner.nextInt();
        scanner.close();

        String[] strs = str.split(" ");
        int[] weight = new int[strs.length];
        int i = 0;
        for (String s : strs) {
            weight[i++] = Integer.valueOf(s);
        }

        System.out.println(fun(weight,limit));

    }

    public static int fun(int[] weight,int limit){
        Arrays.sort(weight);
        int res = 0;
        int i = 0,j=weight.length-1;
        while(i<=j){
            if(i == j){
                res ++;
                break;
            }
            if(weight[i]+weight[j] > limit){
                res++;j--;
            }else{
                res++;i++;j--;
            }
        }
        return res;
    }
}
