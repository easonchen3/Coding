package 剑指offer;

import LeetCode.ListNode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-26 14:11
 * @Version 1.0
 */
public class 链表中环的入口结点
{
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(pHead == null || pHead.next == null){
            return null;
        }
        ListNode slow = pHead;
        ListNode fast = pHead.next;
        while(fast!=null && slow!=null){
            if(slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast!=slow){
                fast = fast.next;
            }
        }
        return null;
    }
}
