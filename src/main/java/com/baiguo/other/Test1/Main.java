package com.baiguo.other.Test1;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-14 13:54
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] letters = new String[n];
        for(int i = 0;i<n;i++){
            letters[i] = scanner.next();
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<letters.length;i++){
            stringBuilder.append(fun(letters[i])).append(" ");
        }
        System.out.println(stringBuilder.toString());

    }
    public static String fun(String s){
        Map<Integer,Character> map = new TreeMap<>();
        int i = 1,j=2;
        for(char ignored :s.toCharArray()){
            map.put(i,ignored);
            i+=2;
        }
        for (int k = s.length()-1; k >= 0; k--,j+=2) {
            map.put(j,s.charAt(k));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for(i=1;i<s.length()+1;i++){
            stringBuilder.append(map.get(i));
        }
        return stringBuilder.toString();
    }


}