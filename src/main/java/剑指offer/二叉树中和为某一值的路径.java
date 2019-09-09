package 剑指offer;

import java.util.ArrayList;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-09 15:02
 * @Version 1.0
 */
public class 二叉树中和为某一值的路径 {
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    ArrayList<Integer> list =  new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if(root == null){
            return res;
        }
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null){
            res.add(list);
        }
        FindPath(root.left,target);
        FindPath(root.right,target);
        list.remove(list.size()-1);
        return res;
    }
}
