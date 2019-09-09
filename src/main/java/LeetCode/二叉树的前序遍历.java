package LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-03 09:27
 * @Version 1.0
 */
public class 二叉树的前序遍历 {

    private List<Integer> list = new ArrayList<>();

    public List<Integer> preorderTraversal1(TreeNode root) {
        helper(root);
        return list;
    }

    public void helper(TreeNode root){
        if(root == null){
            return ;
        }
        preorderTraversal(root.left);
        list.add(root.val);
        preorderTraversal(root.right);
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return list;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            list.add(temp.val);
            if(temp.right != null) stack.push(temp.right);
            if(temp.left != null) stack.push(temp.left);
        }
        return list;
    }
}
