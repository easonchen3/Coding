package 笔试.去哪儿;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-12 15:39
 * @Version 1.0
 */
public class 二叉树遍历 {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        if(s1 == null || s2== null){
            System.out.println("");
            return ;
        }
        TreeNode root = build(s1, 0, s1.length() - 1, s2, 0, s2.length() - 1);
        print(root);
        scanner.close();
    }

    private static TreeNode build(String mid,int start1,int end1,String post,int start2,int end2){
        if(start1 > end1 || start2 > end2){
            return null;
        }
        char rootva = post.charAt(end2);
        TreeNode root = new TreeNode(rootva);
        int k = 0;
        for (int i = 0; i < mid.length(); i++) {
            if(mid.charAt(i) == rootva){
                k= i;
                break;
            }
        }
        root.left = build(mid,start1,k-1,post,start2,start2+k-(start1+1));
        root.right = build(mid,k+1,end1,post,start2+k-start1,end2-1);
        return root;
    }

    private static void print(TreeNode root){
        if(root!=null){
            System.out.print(root.val);
            print(root.left);
            print(root.right);
        }
    }

    static class TreeNode{
        char val;
        TreeNode left;
        TreeNode right;
        TreeNode(char val){
            this.val = val;
        }
    }
}
