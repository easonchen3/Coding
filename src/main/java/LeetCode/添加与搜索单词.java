package LeetCode;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-02 15:48
 * @Version 1.0
 */
public class 添加与搜索单词 {
}
class WordDictionary {

    private Map<Integer,Set<String>> map;
    /** Initialize your data structure here. */
    public WordDictionary() {
        this.map = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word){
        if(word == null){
            return;
        }
        int len = word.length();
        if(map.containsKey(len)){
            map.get(len).add(word);
        }else{
            Set<String> set = new HashSet<>();
            set.add(word);
            map.put(len,set);
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        if(word == null){
            return false;
        }
        int len = word.length();
        if(map.containsKey(len)){
            Set<String> strings = map.get(len);
            for (String string : strings) {
                if(fun(word,string)){
                    return true;
                }
            }
            return false;
        }else{
            return false;
        }
    }

    public boolean fun(String word,String s2){
        char[] words = word.toCharArray();
        char[] chars = s2.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if(words[i] == '.'){
                continue;
            }
            if(words[i]!=chars[i]){
                return false;
            }
        }
        return true;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
