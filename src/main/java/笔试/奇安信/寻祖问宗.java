package 笔试.奇安信;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-09 20:17
 * @Version 1.0
 */
public class 寻祖问宗 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int len = (int) (Math.pow(2,n)-1);
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int min = Math.min(a,b);
        int max = Math.max(a,b);
        for (int i = 0; i < arr.length; i++) {
            if(min < arr[i] && max > arr[i] && arr[i] != -1){
                System.out.println(arr[i]);return ;
            }
        }
       scanner.close();
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
        }
    }
}
