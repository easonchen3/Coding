package LeetCode;

import java.util.*;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-23 12:51
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

public class 树的遍历 {

    /**
     * 递归先序遍历二叉树
     * @param root
     */
    public List<Integer> First1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        res.add(root.val);
        First1(root.left);
        First1(root.right);
        return res;
    }

    /**
     * 递归中序遍历二叉树
     * @param root
     */
    public List<Integer> Midime1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Midime1(root.left);
        res.add(root.val);
        Midime1(root.right);
        return res;
    }

    /**
     * 递归后序遍历二叉树
     * @param root
     */
    public List<Integer> Past1(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Past1(root.left);
        Past1(root.right);
        res.add(root.val);
        return res;
    }

    /**
     * 非递归先序遍历二叉树  遍历顺序：根节点，左子树，右子树
     * @param root
     */
    public List<Integer> First2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            TreeNode temp = stack.pop();
            if(temp == null) continue;
            res.add(temp.val);
            if(temp.right!=null) stack.push(temp.right);
            if(temp.left!=null) stack.push(temp.left);
        }
        return res;
    }

    /**
     * 非递归中序遍历二叉树 遍历顺序：左子树，根子树，右子树
     * @param root
     */
    public List<Integer> Midime2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
        }
        return  res;
    }

    /**
     *非递归后序遍历二叉树 遍历顺序：左子树，右子树，根节点
     * @param root
     * @return
     */
    public List<Integer> Past2(TreeNode root){
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(!stack.empty() || root!=null){
            while(root!=null){
                res.add(0,root.val);
                stack.add(root);
                root = root.right;
            }
            root = stack.pop();
            root = root.left;
        }
        return res;
    }

    /**
     * 求二叉树的高度
     * @param root
     * @return
     */
    public int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }
        int leftHigh = getHeight(root.left);
        int rightHigh = getHeight(root.right);
        return Math.max(leftHigh,rightHigh)+1;
    }

    /**
     * 二叉树的层次遍历
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            List<Integer> list = new ArrayList<>();
            while(count>0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
                count --;
            }
            res.add(list);
        }
        return res;
    }
}
