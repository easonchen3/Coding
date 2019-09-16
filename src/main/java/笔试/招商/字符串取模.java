package 笔试.招商;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-15 21:24
 * @Version 1.0
 */
public class 字符串取模 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String str = scanner.nextLine();
        System.out.println(fun(str));
       scanner.close();
    }

    public static int fun(String str){
        String s = str.replaceAll("\\?", ".*");
        int sum = 0;
        for(int i = 0;i<Math.pow(10,str.length());i++){
            if(i%13 == 5 && String.valueOf(i).matches(s)){
                sum++;
            }
        }
        return sum%(1000000007);
    }
}
