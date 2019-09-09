package com.baiguo.other.leetcode;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-18 23:35
 * @Version 1.0
 */
public class GCRootDemo {
    public static void main(String[] args){
       ListNode head = new ListNode(1);
       ListNode temp = head;
        for (int i = 2; i <= 5 ; i++) {
            ListNode newList = new ListNode(i);
            temp.next = newList;
            temp = temp.next;
        }
        head = reverser2(head,3);
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static ListNode reverser2(ListNode head,int num){
        if(head==null || head.next==null){
            return head;
        }
        int length = 0;
        ListNode test = head;
        while(test!=null){
            length++;
            test = test.next;
        }
        if(num >= length){
            return reveser(head,null);
        }
        ListNode begin,end=head;
        int cnt = num;
        ListNode result = null;
        ListNode last = new ListNode(0);
        boolean flag = true;
        while(head!=null){
            begin = head;
            while((cnt--)>0){
                if(head!=null && head.next!=null){
                    head = head.next;
                }else{
                    return result;
                }
            }
            end = head;
            ListNode newhead = reveser(begin,end);
            if(flag){
                result = newhead;
                flag = false;
            }
            last.next = newhead;
            last = begin;
            cnt = num;
        }
        return result;
    }



    public static ListNode reveser(ListNode head,ListNode end){
        ListNode curr = head;
        ListNode pre = end;
        while(curr!=end){
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
