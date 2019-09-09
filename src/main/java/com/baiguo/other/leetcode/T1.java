package com.baiguo.other.leetcode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-06-03 16:44
 * @Version 1.0
 */
public class T1 {

    public static void main(String[] args){
        System.out.println(defangIPaddr("1.1.1.1"));
    }

    public static String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }

    public boolean isSymetrical(TreeNode root){
        if(root == null){
            return true;
        }
        return isSymetrical(root.left,root.right);
    }

    public boolean isSymetrical(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }

        return left.val == right.val && isSymetrical(left.left,right.right)
                    && isSymetrical(left.right,right.left);
    }

}
