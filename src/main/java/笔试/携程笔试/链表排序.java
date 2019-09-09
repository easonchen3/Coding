package 笔试.携程笔试;

import LeetCode.ListNode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-04 20:06
 * @Version 1.0
 */
public class 链表排序 {
    static ListNode partition(ListNode head, int m) {
        ListNode l1 = new ListNode(0);
        ListNode pre = l1;
        ListNode l2 = new ListNode(0);
        ListNode next = l2;

        while(head != null){
            if(head.val <= m){
                pre.next = head;
                pre = pre.next;
            }else{
                next.next = head;
                next = next.next;
            }
            head = head.next;
        }
        next.next = null;
        pre.next = l2.next;
        return l1.next;
    }
}
