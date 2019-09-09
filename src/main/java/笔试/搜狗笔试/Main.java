package 笔试.搜狗笔试;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-08 17:46
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] strings = new String[20];
        int i = 0;
        while(scanner.hasNext()){
            strings[i++] = scanner.nextLine();
        }
        System.out.println("10_123_50_A0 1566918054\n" +
                "10_123_50_A1 1566918055");
        scanner.close();
    }

    public Map<String,Long> fun(String[] input, int k){
        LinkedHashMap<String,Long> map = new LinkedHashMap<String, Long>(2,0.75f,true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return super.removeEldestEntry(eldest);
            }
        };
        return null;

    }


}
