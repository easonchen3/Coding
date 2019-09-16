package 笔试.明略科技;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-15 15:36
 * @Version 1.0
 */
public class 人民币转化 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        double num = scanner.nextDouble();
        System.out.println(toBig(num));
       scanner.close();
    }

    private static String toBig(double value){
        char[] hunit = {'拾','佰','仟'};
        char[] vunit = {'万','亿'};
        char[] digit = {'零','壹','贰','叄','肆','伍','陆','柒','捌','玖'};
        long midVal = (long)(value*100);
        String valString = String.valueOf(midVal);

        String head = valString.substring(0,valString.length()-2);
        String rail = valString.substring(valString.length()-2);

        StringBuilder prefix = new StringBuilder();
        String suffix = "";
        if(rail.equals("00")){
            suffix = "整";
        }else {
            suffix = digit[rail.charAt(0)-'0'] + "角" +digit[rail.charAt(1)-'0'] + "分";
        }

        char[] chDig = head.toCharArray();
        char zero = '0';
        byte zeroSerNum = 0;
        for (int i = 0; i < chDig.length; i++) {
            int idx = (chDig.length-i-1)%4;
            int vidx = (chDig.length-i-1)/4;
            if(chDig[i] == '0'){
                zeroSerNum++;
                if(zero == '0'){
                    zero = digit[0];
                }else if(idx == 0 && vidx > 0 && zeroSerNum < 4) {
                    prefix.append(vunit[vidx - 1]);
                    zero = '0';
                }
                continue;
            }
            zeroSerNum = 0;
            if(zero != '0'){
                prefix.append(zero);
                zero = '0';
            }
            prefix.append(digit[chDig[i] - '0']);
            if(idx > 0){
                prefix.append(hunit[idx - 1]);
            }
            if(idx == 0 && vidx > 0){
                prefix.append(vunit[vidx - 1]);
            }
        }
        if(prefix.length() > 0){
            prefix.append("元");
        }
        return prefix+suffix;
    }
}
