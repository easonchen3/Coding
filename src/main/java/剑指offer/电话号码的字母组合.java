package 剑指offer;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-21 14:45
 * @Version 1.0
 */
public class 电话号码的字母组合 {

    public List<String> letterCombinations(String digits) {
        Map<Character, List<Character>> map = new HashMap<Character, List<Character>>() {{
            put('2', Arrays.asList('a', 'b', 'c'));
            put('3', Arrays.asList('d', 'e', 'f'));
            put('4', Arrays.asList('g', 'h', 'i'));
            put('5', Arrays.asList('j', 'k', 'l'));
            put('6', Arrays.asList('m', 'n', 'o'));
            put('7', Arrays.asList('p', 'q', 'r', 's'));
            put('8', Arrays.asList('t', 'u', 'v'));
            put('9', Arrays.asList('w', 'x', 'y', 'z'));
        }};

        List<String> list = new ArrayList<>();


        return list;
    }

}
