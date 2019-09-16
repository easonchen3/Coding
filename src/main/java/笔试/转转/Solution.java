package 笔试.转转;

import org.omg.PortableInterceptor.INACTIVE;
import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    class Node{
        int val;
        Node left;
        Node right;
        public Node(int val){
            this.val = val;
        }
    }

    private Node createBinaryTreeByArray(Integer[] array,int index)
    {
        Node tn = null;
        if (index<array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            tn = new Node(value);
            tn.left = createBinaryTreeByArray(array, 2*index+1);
            tn.right = createBinaryTreeByArray(array, 2*index+2);
            return tn;
        }
        return tn;
    }

    public int levelOrder(Node root){
        if(root == null){
            return 0;
        }
        int res = 0;
        int index = 1;
        double max = Integer.MIN_VALUE,avg = 0,sum = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while(!queue.isEmpty()){
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                sum+=node.val;
                if(node.left!=null){ queue.add(node.left); }
                if(node.right!=null){ queue.add(node.right); }
            }
            avg = sum/count;
            if(max <= avg){
              max = avg;
              res = index;
            }
            sum = 0;

            index++;
        }
        return res;

    //请您完成此方法
    }


        public  Node createTree(int[] array){
            List<Node> nodeList=new LinkedList<Node>();

            for(int nodeIndex=0;nodeIndex<array.length;nodeIndex++){
                nodeList.add(new Node(array[nodeIndex]));
            }
            for(int parentIndex=0;parentIndex<=array.length/2-1;parentIndex++){
                nodeList.get(parentIndex).left =nodeList.get(parentIndex*2+1);
                //防止是非完全二叉树
                if((parentIndex*2+2)<array.length) {
                    nodeList.get(parentIndex).right = nodeList.get(parentIndex * 2 + 2);
                }
            }
            return nodeList.get(0);
        }


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        //int [] array = new int [n];
        Integer [] array = new Integer[n];
        for(int i = 0;i < n;i++){
            String value =scanner.next();
            if(value.equals( "null" )){
                array[i]=null;
            }else{
                array[i] = Integer.valueOf( value );
            }

        }
        Solution solution = new Solution ();
        Node root =solution.createBinaryTreeByArray(array,0);
        int level = solution.levelOrder( root );
        System.out.println(level);

    }
}