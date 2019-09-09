package LeetCode;



/**
 * @Author: BaoJian.Xu
 * @Date: 2019-09-02 15:18
 * @Version 1.0
 */
public class 两数相加II {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode num1 = rever(l1);
        ListNode num2 = rever(l2);
        int temp = 0;
        ListNode head = new ListNode(0);
        ListNode l3 = head;
        while (num1 != null || num2 != null) {
            int x = (num1 != null) ? num1.val : 0;
            int y = (num2 != null) ? num2.val : 0;
            l3.next = new ListNode((x + y + temp) % 10);
            l3 = l3.next;
            temp = (x + y + temp) / 10;
            if (num1 != null) {
                num1 = num1.next;
            }
            if (num2 != null) {
                num2 = num2.next;
            }
        }
        if (temp > 0) {
            l3.next = new ListNode(temp);
        }
        return rever(head.next);
    }

    public static ListNode rever(ListNode head) {
        if (head == null) return null;
        ListNode curr = head;
        ListNode pre = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode list1 = ListNode.createList(new int[]{7,2,4,3});
        ListNode list2 = ListNode.createList(new int[]{5,6,4});
        ListNode listNode = addTwoNumbers(list1, list2);
        ListNode.printListNode(listNode);
    }
}
