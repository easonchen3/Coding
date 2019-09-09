package 剑指offer;

import LeetCode.ListNode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-08-25 21:04
 * @Version 1.0
 */
public class 两个链表的第一个公共结点 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == null || pHead2 == null){
            return null;
        }
        int len1 = findLength(pHead1);
        int len2 = findLength(pHead2);

        int dis = Math.abs(len1-len2);
        ListNode longList = (len1>len2)?pHead1:pHead2;
        ListNode shortList = (len1>len2)?pHead2:pHead1;
        while((dis--)>0){
            longList = longList.next;
        }
        while(longList!=null && shortList!=null){
            if(longList == shortList){
                return longList;
            }
            longList = longList.next;
            shortList = shortList.next;
        }
        return null;
    }

    public int findLength(ListNode head){
        if(head == null){
            return 0;
        }
        int sum = 1;
        while(head!=null){
            sum++;
            head = head.next;
        }
        return sum;
    }
}
