package LeetCode;

import sun.misc.Unsafe;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-20 16:16
 * @Version 1.0
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val){
        this.val = val;
    }


    public static ListNode createList(int[] nums){
        if(nums == null){
            return null;
        }
        if(nums.length == 1){
            ListNode root = new ListNode(nums[0]);
            root.next = null;
            return root;
        }
        ListNode root = new ListNode(nums[0]);
        ListNode temp = root;
        for (int i = 1; i < nums.length; i++) {
            temp.next = new ListNode(nums[i]);
            temp = temp.next;
        }
        temp = null;
        return root;
    }

    public static void printListNode(ListNode root){
        if(root == null){
            return ;
        }
        System.out.print(root.val);
        root = root.next;
        while(root!=null){
            System.out.print("->"+root.val);
            root = root.next;
        }
    }
    public static void main(String[] args){
        Unsafe.getUnsafe().addressSize();

    }
}
