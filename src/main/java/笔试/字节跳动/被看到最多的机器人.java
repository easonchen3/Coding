package 笔试.字节跳动;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-08 19:58
 * @Version 1.0
 */
public class 被看到最多的机器人 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

       scanner.close();

        int[] flag = new int[n];
        for (int i = n-1; i >= 0 ; i--) {
            for (int j = i-1; j >=0 ; j--) {
                if(data[j] >= data[i]){
                    flag[j] = flag[j]+i;
                    break;
                }
            }
        }
        int index = 0;
        int max = -1;
        for (int i = 0; i <n; i++) {
            if(flag[i] > max){
                max = flag[i];
                index = i;
            }
        }
        System.out.println(data[index]);
    }

}
