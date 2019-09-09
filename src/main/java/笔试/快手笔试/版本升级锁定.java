package 笔试.快手笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-25 17:40
 * @Version 1.0
 */
public class 版本升级锁定 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String n1 = scanner.nextLine();
        Integer n = Integer.valueOf(n1);
        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }
        for (String string : strings) {
            String[] temp = string.split(" ");
            System.out.println(fun(temp[0],temp[1]));
        }
    }


    public static boolean fun(String str1,String str2) {

        String[] split1 = str1.split("\\.");
        String[] split2 = str2.split("\\.");
        int index = 0;
        while (index < split1.length && index < split2.length) {
            int l = Integer.parseInt(split1[index]);
            int r = Integer.parseInt(split2[index]);
            if (l > r) {
                return false;
            } else if (r > l) {
                return true;
            } else {
                index++;
            }
        }
        for (int i = split1.length; i < split2.length; i++) {
            if (Integer.valueOf(split2[i]) > 0) {
                return true;
            }
        }
        return false;
    }
}
