package LeetCode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-07 17:58
 * @Version 1.0
 */
public class K个一组翻转链表 {

    public ListNode reverseKGroup(ListNode head,int k){
        ListNode temp = head;
        for (int i = 1; i < k && temp!=null; i++) {
            temp = temp.next;
        }
        //如果链表的长度不满足k段一组就直接返回
        if(temp == null){
            return head;
        }
        ListNode t2 = temp.next;
        temp.next = null;
        //将head-temp;也就是k个一组进行逆置，将逆置之后的头为newHead
        ListNode newHead = reverser(head);
        //递归逆序下一段
        ListNode newTemp = reverseKGroup(t2,k);
        //将两部门连接起来
        head.next = newTemp;
        return newHead;
    }

    /**
     * 递归逆序链表
     * @param head
     * @return
     */
    public ListNode reverser(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = reverser(head.next);
        head.next.next = head;
        head.next = null;
        return result;
    }
}
