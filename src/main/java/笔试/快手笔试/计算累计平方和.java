package 笔试.快手笔试;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-25 17:12
 * @Version 1.0
 */
public class 计算累计平方和 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
            int n = in.nextInt();
            int[] array = new int[n];
            for(int i = 0; i < n; i++){
                array[i] = in.nextInt();
            }
            in.close();
            boolean[] results = new boolean[array.length];
            int i = 0;
            for (int num : array) {
                results[i] = check(num);
                i++;
            }

            for (boolean result : results) {
                System.out.println(result);
            }
        }

        public static boolean check(int num){
            if(num ==1) {
                return true;
            }
            Set<Integer> set = new HashSet<>();
            int temp = 0;
            while (true){
                while (num != 0){
                    temp += Math.pow(num%10,2);
                    num/=10;
                }
                if(temp == 1){
                    return true;
                }
                if(set.contains(temp)){
                    return false;
                }else {
                    set.add(temp);
                    num = temp;
                    temp = 0;
                }
            }
        }
    }
