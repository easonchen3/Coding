package 笔试.笔试58;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-12 20:59
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s = scanner.nextLine();
        System.out.println(fun(s));
       scanner.close();
    }

    private static int fun(String s){
        String[] chars = s.split(",");
        Set<String> set = new HashSet<>();
        for (String aChar : chars) {
            set.add(aChar);
        }
        return set.size();
    }
}
