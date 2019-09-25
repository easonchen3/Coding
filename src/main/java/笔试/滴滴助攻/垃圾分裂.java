package 笔试.滴滴助攻;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-19 19:43
 * @Version 1.0
 */
public class 垃圾分裂 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       int n = scanner.nextInt();
       int m = scanner.nextInt();
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < m; i++) {
            set1.add(scanner.nextInt());
            set2.add(scanner.nextInt());
        }
        if(set1.size() == 0 ){
            System.out.println(n/2*2);
        }else{
            int max = set1.size() > set2.size() ? set1.size() : set2.size();
            int min = set1.size() < set2.size() ? set1.size() : set2.size();
            int len = (max >= n/2) ? (n/2*2) : (min*2);
            System.out.println(len);
        }
       scanner.close();
    }
}
