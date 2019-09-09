package LeetCode;


/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-03 09:10
 * @Version 1.0
 */
public class 比较版本号 {

    public static void main(String[] args){
        System.out.println(compareVersion("1.01","1.001"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] split1 = version1.split("\\.");
        String[] split2 = version2.split("\\.");
        for (int i = 0; i < Math.max(split1.length, split2.length); i++) {
            int num1 = (i<split1.length)?Integer.valueOf(split1[i]):0;
            int num2 = (i<split2.length)?Integer.valueOf(split2[i]):0;
            if(num1 < num2){
                return -1;
            }else if(num1 > num2){
                return 1;
            }
        }
        return 0;
    }
}
