package LeetCode;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-26 16:05
 * @Version 1.0
 */
public class 检测大写字母 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        System.out.println(detectCapitalUse(s));
        scanner.close();
    }

    public static boolean detectCapitalUse(String word) {
       /*if(word.matches("[A-Z]+")){
            return true;
        }*/
        return word.matches("([A-Z]?[a-z]+)|([A-Z]*)");
    }
}
