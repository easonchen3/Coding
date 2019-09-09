package 笔试.美团笔试;


import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-22 15:56
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        scanner.close();
        String[] strs = string.split(" ");
        System.out.println(fun(strs));
    }
    public static String fun(String[] words) {
        if(words == null || words.length == 0){
            return "invalid";
        }
        Map<Character, Set<Character>> map = new HashMap<>();
        Map<Character, Integer> degree = new HashMap<>();
        String res = "";
        if (words.length == 0){
            return res;
        }
        for (String word : words){
            for (char ch : word.toCharArray()){
                if (!degree.containsKey(ch)){
                    degree.put(ch, 0);
                }
            }
        }
        for (int i = 0; i < words.length - 1; i++){
            String cur = words[i];
            String next = words[i + 1];
            int length = Math.min(cur.length(), next.length());
            for (int j = 0; j < length; j++){
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                if (c1 != c2){
                    Set<Character> set = map.getOrDefault(c1, new HashSet<Character>());
                    if (!set.contains(c2)){
                        set.add(c2);
                        map.put(c1, set);
                        degree.put(c2, degree.get(c2) + 1);
                    }
                    break;
                }
            }
        }
        Queue<Character> queue = new LinkedList<>();
        for (char c : degree.keySet()){
            if (degree.get(c) == 0){
                queue.add(c);
            }
        }
        while (!queue.isEmpty()){
            char c = queue.remove();
            res += c;
            if (map.containsKey(c)){
                for (char ch : map.get(c)){
                    degree.put(ch, degree.get(ch) - 1);
                    if (degree.get(ch) == 0){
                        queue.add(ch);
                    }
                }
            }
        }
        if (res.length() != degree.size()){
            return "invalid";
        }
        return res;
    }
}
