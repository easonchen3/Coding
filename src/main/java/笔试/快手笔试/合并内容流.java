package 笔试.快手笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-25 16:49
 * @Version 1.0
 */
public class 合并内容流 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        System.out.println(fun(str1,str2));
    }

    public static String fun(String str1,String str2){
        if(str1 == null){
            return str2;
        }
        if(str2 == null){
            return str1;
        }
        String[] split1 = str1.split(" ");
        String[] split2 = str2.split(" ");

        StringBuilder sb = new StringBuilder();
        int j = 0;
        for (int i = 0; i < split1.length; i++) {
            sb.append(split1[i]).append(" ");
            if((i+1)%4 == 0 && j<split2.length){
                sb.append(split2[j++]).append(" ");
            }
        }
        while(j<split2.length){
            sb.append(split2[j++]).append(" ");
        }
        return sb.toString().substring(0,sb.length()-1);
    }
}
