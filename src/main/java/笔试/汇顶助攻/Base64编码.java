package 笔试.汇顶助攻;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-26 19:09
 * @Version 1.0
 */
public class Base64编码 {
    public static void main(String[] args){
        System.out.println(fun("adfg".toCharArray()));
    }

    public static String fun(char[] str){
        char[] index = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            char ch = str[i];
            int ascii = (int)ch;
            sb.append(toBinary(ascii,8));
        }
        String result = sb.toString();
        StringBuilder res = new StringBuilder();
        int start = 0,end = 0;
        while(start<result.length()){
            if((start+6)<result.length()){
                end = start+6;
            }else{
                break;
            }
            String temp = result.substring(start,end);
            int i1 = Integer.valueOf(temp,2);
            res.append(index[i1]);
            start = end;
        }
        String last = result.substring(start,result.length());
        StringBuilder lastBuilder = new StringBuilder(last);
        for (int i = 0; i < (6 - last.length()); i++) {
            lastBuilder.append("0");
        }
        res.append(index[Integer.valueOf(lastBuilder.toString(),2)]);
        if(str.length%3 == 1){
            res.append("==");
        }
        return res.toString();
    }

    private static String toBinary(int num,int digits){
        int value = 1<<digits | num;
        String bs = Integer.toBinaryString(value);
        return bs.substring(1);
    }
}
