package 笔试.当当笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-02 20:11
 * @Version 1.0
 */
public class 金额大写转换 {

    private static final char[] nums = new char[]{'零','壹','贰','叁','肆','伍','陆','柒','捌','玖'};
    static String[][] nuit = {{"元","万","亿"},{"","拾","佰","仟"}};
    private static String[] dunit = {"角","分"};

    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s = scanner.nextLine();

        System.out.println();
       scanner.close();
    }

}
