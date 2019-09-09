package 笔试.携程笔试;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-04 19:41
 * @Version 1.0
 */
public class 表达式解析 {

    public static void main(String[] args) {
        System.out.println(resolve("((ur)oi)"));
    }

    static String resolve(String expr) {
        if (expr.equals("") || expr == null) {
            return "";
        }
        LinkedList<Integer> list = new LinkedList<>();
        char[] chars = expr.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                list.addFirst(i);
                continue;
            }
            if (chars[i] == ')') {
                if (list.isEmpty()) {
                    return "";
                }
                help(chars, list.removeFirst() + 1, i - 1);
            }
        }
        if (!list.isEmpty()) {
            return "";
        }
        for (char aChar : chars) {
            if (aChar == '(' || aChar == ')') {
                continue;
            }
            sb.append(aChar);
        }
        return sb.toString();
    }

    public static void help(char[] data, int i, int j) {
        while (i < j) {
            char temp = data[i];
            data[i] = data[j];
            data[j] = temp;
            i++;
            j--;
        }
    }
}
