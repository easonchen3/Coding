package 笔试.米哈游;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-07 18:42
 * @Version 1.0
 */
public class Main1 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);

       String s = scanner.nextLine();
        fun("A3bc2x-b2");
       scanner.close();
    }

    public static int fun(String s) {
        /*char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        sb.append(chars[0]);
        int index = 0;
        for (int i = 0; i < chars.length; i++) {

        }
        for (int i = 1; i < chars.length; i++) {
            char c = chars[i - 1];
            if (chars[i] > '0' && chars[i] < '9') {

                index = i+1;
                int num = Integer.valueOf(chars[i]);
                for (int j = 0; j < num; j++) {
                    sb.append(chars[i - 1]);
                }
            } else if (chars[i] == '-') {
                while (c < chars[i + 1]) {
                    c++;
                    sb.append(c);
                }
            }else{
                sb.append(chars[i]);
            }
        }
        System.out.println(sb.toString());*/
        return 0;
    }
}
