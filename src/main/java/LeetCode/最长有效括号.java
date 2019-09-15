package LeetCode;

import java.util.Stack;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-14 23:46
 * @Version 1.0
 */
public class 最长有效括号 {

    public static void main(String[] args){
        System.out.println(longestValidParentheses(")()())"));
    }

    /**
     * 使用栈的思想，栈中保留是上次左括号的索引，找到右括号的时候计算每次的最长串长度
     * @param s
     * @return
     */
    private static int longestValidParentheses(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(tmp == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    res = Math.max(res,i-stack.peek());
                }
            }
        }
        return res;
    }
}
