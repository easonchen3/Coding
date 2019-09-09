package 笔试.吉比特;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-05 21:12
 * @Version 1.0
 */
public class 查找子串 {

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s1 = scanner.next();
       String s2 = scanner.next();

        System.out.println(find(s1,s2));
       scanner.close();
    }

    public static int find(String s1,String s2){
        if(s1 == null || s2 == null){
            return 0;
        }


        int[] temp = new int[s2.length()];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = s1.lastIndexOf(s2.charAt(i));
        }
        boolean flag = true;
        if(s1.charAt(0) != s2.charAt(0) && temp[0] == 0){
            return 0;
        }
        for (int i = 1; i < temp.length; i++) {
            if(temp[i] == 0){
                return 0;
            }
            if(temp[i-1] > temp[i]){
                flag = false;
            }
        }
        if(flag == false){
            return s1.substring(0,temp[0]).lastIndexOf(s2.charAt(0))+1;
        }else{
            return temp[0]+1;
        }
    }

    public static int fun(String string1,String string2){
        char[] s1 = string1.toCharArray();
        char[] s2 = string2.toCharArray();
        for (int i = s1.length-1; i >= 0 ; i--) {
            if(s1[i] == s2[0]){
                int p = i+1;
                int q = 1;
                while(p < s1.length && q < s2.length){
                    if(s1[p] == s2[q]){
                        q++;
                    }
                    p++;
                }
                if(q == s2.length){
                    return i+1;
                }
            }
        }
        return 0;
    }
}
