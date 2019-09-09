package 剑指offer;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-01 16:41
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
public class 重建二叉树 {

    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        TreeNode root = build(pre, 0, pre.length - 1, in, 0, in.length - 1);
        return root;
    }


    public TreeNode build(int[] preOder,int preStart,int preEnd,int[] inOrder,int inStart,int inEnd){
        if(preStart > preEnd || inStart > inEnd){
            return null;
        }

        TreeNode root = new TreeNode(preOder[preStart]);
        for (int i = inStart; i <= inEnd; i++) {
            if(inOrder[i] == preOder[preStart]){
                root.left = build(preOder,preStart+1,preStart+i-inStart,inOrder,inStart,i-1);
                root.right = build(preOder,i-inStart+preStart+1,preEnd,inOrder,i+1,inEnd);
                break;
            }
        }
        return root;
    }

    private TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {

        if (startPre > endPre || startIn > endIn) {
            return null;
        }
        TreeNode root = new TreeNode(pre[startPre]);
        for (int i = startIn; i <= endIn; i++)
            if (in[i] == pre[startPre]) {
                root.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                root.right = reConstructBinaryTree(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        return root;
    }
}
