package 笔试.疯狂游戏;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-19 19:17
 * @Version 1.0
 */
public class 公共前缀 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s = scanner.nextLine();
        String[] split = s.split(" ");
        System.out.println(fun(split));
        scanner.close();
    }

    public static String fun(String[] strs){
        if(strs == null || strs.length == 0){
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].charAt(i) != strs[0].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }
}
