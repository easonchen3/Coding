package 笔试.明略科技;

import org.apache.ibatis.annotations.Param;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-15 16:00
 * @Version 1.0
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String num = scanner.next();
        String[] split = num.split("\\.");
        System.out.println("人民币" + left(split[0]) + right(split[1]));
        scanner.close();
    }

    private static String left(String left) {
        String leftCn = "";
        String[] zhcn = {"零", "壹", "贰", "叄", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] unicn = {"", "拾", "佰", "仟"};

        if (left.length() <= 4) {
            for (int i = 0; i < left.length(); i++) {
                leftCn = leftCn + zhcn[(int) left.charAt(i) - 48] + unicn[left.length() - i - 1];
            }
            leftCn = leftCn + "元";
        }
        if (left.length() <= 8 && left.length() > 4) {
            for (int i = 0; i < left.length() - 4; i++) {
                leftCn = leftCn + zhcn[(int) left.charAt(i) - 48] + unicn[left.length() - i - 5];
            }
            leftCn = leftCn + "万";

            for (int i = left.length() - 4; i < left.length(); i++) {
                leftCn = leftCn + zhcn[(int) left.charAt(i) - 48] + unicn[left.length() - i - 1];
            }
            leftCn = leftCn + "元";
        }

        if (left.length() <= 13 && left.length() > 8) {
            for (int i = 0; i < left.length() - 8; i++) {
                leftCn = leftCn + zhcn[(int) left.charAt(i) - 48] + unicn[left.length() - i - 9];
            }
            leftCn = leftCn + "亿";
            for (int i = left.length() - 8; i < left.length() - 4; i++) {
                leftCn = leftCn + zhcn[(int) left.charAt(i) - 48] + unicn[left.length() - i - 5];
            }
            leftCn = leftCn + "万";
            for (int i = left.length() - 4; i < left.length(); i++) {
                leftCn = leftCn + zhcn[(int) left.charAt(i) - 48] + unicn[left.length() - i - 1];
            }
            leftCn = leftCn + "元";
        }
        if (leftCn.charAt(0) == '壹' && leftCn.charAt(1) == '拾') {
            leftCn = leftCn.substring(1);
        }

        while (scanString(leftCn) == 1) {
            for (int i = 0; i < left.length() - 1; i++) {
                if (leftCn.charAt(i) == '零' && (leftCn.charAt(i + 1) == '亿' || leftCn.charAt(i + 1) == '万')) {
                    leftCn = leftCn.substring(0, i) + leftCn.substring(i + 1);
                }
                if (leftCn.charAt(i) == '零' && (leftCn.charAt(i + 1) == '拾' || leftCn.charAt(i + 1) == '佰' || leftCn.charAt(i + 1) == '仟' ||
                        leftCn.charAt(i + 1) == '元' || leftCn.charAt(i + 1) == '零')) {
                    leftCn = leftCn.substring(0, i + 1) + leftCn.substring(i + 2);
                }
            }
        }
        if (leftCn.charAt(leftCn.length() - 1) == '零') {
            leftCn = leftCn.substring(0, left.length() - 1) + "元";
        }
        if (leftCn.charAt(leftCn.indexOf('万') - 1) == '亿') {
            leftCn = leftCn.substring(0, leftCn.indexOf('万')) + leftCn.substring(leftCn.indexOf('万') + 1);
        }
        return leftCn;
    }

    public static int scanString(String stringIN) {
        int flag = 0;
        for (int i = 0; i < stringIN.length() - 1; i++) {
            if (stringIN.charAt(1) == '零' && (stringIN.charAt(i + 1) == '万' || stringIN.charAt(i + 1) == '亿')) {
                flag = 1;
                break;
            }
            if (stringIN.charAt(1) == '零' && (stringIN.charAt(i + 1) == '拾' || stringIN.charAt(i + 1) == '佰' || stringIN.charAt(i + 1) == '仟' ||
                    stringIN.charAt(i + 1) == '元' || stringIN.charAt(i + 1) == '零')) {
                flag = 1;
                break;
            }
        }
        return flag;
    }

    private static String right(String right) {
        String[] zhcn = {"零", "壹", "贰", "叄", "肆", "伍", "陆", "柒", "捌", "玖"};
        String rightcn = "";
        if (right.charAt(0) == '0' && right.charAt(1) == '0') {
            rightcn = rightcn + "整";
        } else {
            rightcn = rightcn + zhcn[(int) right.charAt(0) - 48] + "角" + zhcn[(int) right.charAt(1) - 48] + "分";
        }
        return rightcn;
    }

}
