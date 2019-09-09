package 笔试.当当笔试;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-02 20:30
 * @Version 1.0
 */
public class 字符统计 {

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s = scanner.nextLine();
        System.out.println(fun(s));
       scanner.close();
    }

    public static int fun(String s){
        Map<Character,Integer> map = new HashMap<>();
        s = s.replaceAll(" ","");
        for (char c : s.toCharArray()) {
            if(!map.containsKey(c)){
                map.put(c,1);
            }else{
                map.put(c,map.get(c)+1);
            }
        }
        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        ArrayList<Map.Entry<Character, Integer>> list = new ArrayList<>(entries);
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        return list.get(0).getValue();
    }
}
