package LeetCode;


/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-10 10:24
 * @Version 1.0
 */
public class 二叉搜索树的最近公共祖先 {

    private TreeNode res;
    private boolean flag = false;
    private boolean b = false;

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode t1 = (p.val > q.val) ? q : p;
        TreeNode t2 = (p.val > q.val) ? p : q;
        helper(root,t1,t2);
        return res;
    }

    private Boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        if((p.val <= root.val && q.val > root.val) || (p.val < root.val && q.val >= root.val)){
            b = helper(root.left, p, q) && helper(root.right, p, q);
        }else if(p.val < root.val && p.val < root.val){
            b = helper(root.left,p,q);
        }else{
            b = helper(root.right,p,q);
        }
        boolean b1 = root.val == p.val || root.val == q.val;
        if(!flag && b&&b1){
            flag = true;
            res = root;
        }
        return b || b1;

    }

}
