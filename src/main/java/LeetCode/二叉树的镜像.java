package LeetCode;

import java.util.Stack;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-30 18:13
 * @Version 1.0
 */
public class 二叉树的镜像 {
    public static void main(String[] args){

    }

    public void reverTree(TreeNode root){
        if(root == null || (root.left == null && root.right == null)){
            return ;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if(root.left!=null){
            reverTree(root.left);
        }
        if(root.right!=null){
            reverTree(root.right);
        }
    }

    public void reverTree2(TreeNode root){
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if(node.left!=null){
                stack.add(node.left);
            }
            if(node.right!=null){
                stack.add(node.right);
            }
        }
    }
}
