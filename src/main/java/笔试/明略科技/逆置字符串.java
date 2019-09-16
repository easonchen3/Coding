package 笔试.明略科技;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-15 15:33
 * @Version 1.0
 */
public class 逆置字符串 {

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s = scanner.nextLine();
        System.out.println(ReverseSentence(s));
       scanner.close();
    }

    private static String ReverseSentence(String str) {
        char[] chars = str.toCharArray();
        if(chars == null || chars.length == 0){
            return null;
        }
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar == ' '){
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
                stack2.push(' ');
            }else{
                stack1.push(aChar);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str.substring(str.lastIndexOf(" ")+1));

        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        return sb.toString();
    }
}
