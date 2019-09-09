package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-24 14:11
 * @Version 1.0
 */
public class 把数组排成最小的数 {
    public static void main(String[] args){
        把数组排成最小的数 test = new 把数组排成最小的数();
        String s = test.PrintMinNumber(new int[]{3, 5, 1, 4, 2});
        System.out.println(s);
    }

    public String PrintMinNumber(int [] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.stream(numbers).forEach(list::add);

        list.sort((o1, o2 )-> {
            String s1 = o1+""+o2;
            String s2 = o2+""+o1;
            return s1.compareTo(s2);
        });

        String s = "";
        for (Integer integer : list) {
            s+=integer;
        }
        return s;
    }
}
