package LeetCode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-09 22:59
 * @Version 1.0
 */
public class 链表排序算法 {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     *  链表的插入排序，用两个指针去记录待排序的位置，再用两个指针找插入的位置，找到了就插入，依次往后遍历链表
     * @param head
     * @return
     */
    public ListNode sort(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head,curr = head.next;
        ListNode ans = new ListNode(-1);
        ans.next = head;
        while(curr!=null){
            if(curr.val < pre.val){
                //如果curr的值比它之前的小。首先提出这个节点
                pre.next = curr.next;
                //从头找到第一个比cur大的位置再进行插入
                ListNode l1 = ans;
                ListNode l2 = ans.next;
                while(curr.val > l2.val){
                    l1 = l2;
                    l2 = l2.next;
                }
                //找到之后把curr节点插入到l1,l2之间
                l1.next = curr;
                curr.next = l2;
                //一次排序完成，将curr移到下一个节点
                curr = pre.next;
            }else{
                pre = curr;
                curr = curr.next;
            }
        }
        return ans.next;
    }
}
