package 笔试.用友笔试;

import java.util.Scanner;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-31 14:42
 * @Version 1.0
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val){
        this.val = val;
    }
}
public class 二叉树推导 {
    public static void main(String[] args){
       Scanner scanner = new Scanner(System.in);
       String s = scanner.nextLine();
        String[] split = s.split(",");
        int[] first = new int[split[0].length()];
        int[] mid = new int[split[0].length()];
        for (int i = 0; i < split[0].length(); i++) {
            first[i] = Integer.valueOf(split[0].charAt(i));
        }
        for (int i = 0; i < split[1].length(); i++) {
            mid[i] = Integer.valueOf(split[1].charAt(i));
        }
        TreeNode root = build(first,mid);
        print(root);
        scanner.close();
    }

    public static void print(TreeNode root){
        if(root == null){
            return;
        }
        print(root.left);
        print(root.right);
        System.out.print((char)root.val);
    }

    public static TreeNode build(int[] first,int[] mid){
        if(first.length == 0 || mid.length == 0){
            return  null;
        }
        TreeNode root = build(first,0,first.length-1,mid,0,mid.length-1);
        return root;
    }

    private static TreeNode build(int[] preorder,int preStart,int preEnd,int[] inorder,int inStart,int inEnd){
        if(preStart>preEnd || inStart > inEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        for (int i = inStart; i <= inEnd ; i++) {
            if(inorder[i] == preorder[preStart]){
                root.left = build(preorder,preStart+1,preStart-inStart+i,inorder,inStart,i-1);
                root.right = build(preorder,preStart-inStart+i+1,preEnd,inorder,i+1,inEnd);
                break;
            }
        }
        return root;
    }

    /*private static TreeNode build(int[] first, int firstStart, int firstEnd, int[] mid, int midStart, int midEnd) {
        if(firstStart > firstEnd || midStart > midEnd){
            return null;
        }
        TreeNode root = new TreeNode(first[firstStart]);
        for (int i = midStart; i <= midEnd; i++) {
            if(mid[i] == first[firstStart]){
                root.left = build(first,firstStart+1,firstStart-midStart+i,mid,midStart,i-1);
                root.right = build(first,firstStart-midStart+i+1,firstEnd,mid,i+1,midEnd);
                break;
            }
        }
        return root;
    }*/

}
