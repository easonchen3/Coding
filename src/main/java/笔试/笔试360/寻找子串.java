package 笔试.笔试360;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-31 16:57
 * @Version 1.0
 */
public class 寻找子串 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        scanner.close();

        int[] arr = new int[26];
        for (int i = 0; i < 26; i++) {
            arr[i] = 0;
        }
        for (char aChar : chars) {
            arr[aChar-'a'] ++;
        }
        int max = 0;
        for (int i = 0; i < 26; i++) {
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);
    }

    /*public static int solve(String s){
        if(s == null || s.trim().equals("")){
            return 0;
        }
        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i+1; j <= s.length(); j++) {
                String temp = s.substring(i,j);
                if(!map.containsKey(temp)){
                    map.put(temp,1);
                }else{
                    map.put(temp,map.get(temp)+1);
                }
            }
        }
        List<Map.Entry<String,Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        return list.get(0).getValue();
    }*/

    private static int printSubString(String s) {
        if (s != null) {
            final Map<String, Integer> map = new LinkedHashMap<>();
            List<String> list = new ArrayList<>();
            for (int start = 0; start < s.length(); start++)
            {
                for (int end = start + 1; end <= s.length(); end++)
                {
                    String subString = s.substring(start, end);
                    if (map.containsKey(subString)) {
                        map.put(subString, map.get(subString) + 1);
                    } else {
                        map.put(subString, 1);
                        list.add(subString);
                    }
                }
            }
            list.sort((o1, o2) -> {
                int i = map.getOrDefault(o1, 0);
                int j = map.getOrDefault(o2, 0);
                return i == j ? o1.compareTo(o2) : (j - i);
            });
            return map.get(list.get(0));
        }
        return 0;
    }
}
