package 剑指offer;

import java.util.regex.Pattern;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-25 16:06
 * @Version 1.0
 */
public class 正则表达式匹配 {

    public static void main(String[] args){
        match("aaa".toCharArray(),"ab*a".toCharArray());
    }

    public static boolean match(char[] str, char[] pattern)
    {
        String string = new String(str);

        String patterns = new String(pattern);
        patterns.replaceAll(".","\\.");
        patterns.replaceAll("\\*","+");
        boolean isMatch = Pattern.matches(patterns,string);
        System.out.println(isMatch);
        return isMatch;
    }
}
