package 剑指offer;

import java.util.Stack;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-09 12:38
 * @Version 1.0
 */
public class 翻转单词顺序 {

    public static void main(String[] args){
        System.out.println(ReverseSentence("student. a am I"));
    }

    public static String ReverseSentence(String str) {
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
        sb.append(str.substring(str.indexOf(" "),str.length()-1)).append(" ");
        while(!stack2.isEmpty()){
            sb.append(stack2.pop());
        }
        return sb.toString();

    }
}
