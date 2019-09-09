package 剑指offer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-01 16:20
 * @Version 1.0
 */
public class 第一个只出现一次的字符 {

    public static void main(String[] args){
        第一个只出现一次的字符 test = new 第一个只出现一次的字符();
        int aabbcde = test.FirstNotRepeatingChar("googgle");
        System.out.println(aabbcde);
    }

    public int FirstNotRepeatingChar(String str) {
        LinkedHashMap<Character,Integer> map = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if(entry.getValue() == 1){
                return str.indexOf(entry.getKey());
            }
        }
        return -1;
    }
}
