package com.baiguo.other.Test1;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-15 15:40
 * @Version 1.0
 */
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
    }
}
public class Test {

    /*public String put(String key,String value){
        if(key == null){
            return null;
        }
        int hash = hash(key);
        Node head = index(hash);
        while(head.next!=null){
            if(key.equals(head.val)){
                head.value = value;
                return value;
            }
            head = head.next;
        }
        Node tail = new Node(key,value);
        head.next = tail;
        return value;
    }*/

    public static ListNode reveser(ListNode head,int n){
        int cnt = 1;
        ListNode pre = null;
        ListNode curr = head;
        ListNode last = null;
        ListNode newHead = null;
        ListNode next = null;
        boolean flag = true;
        while(curr != null){
            if(cnt == 1){
                last = curr;
            }
            if(cnt!=n){
                next = curr.next;
                curr.next = pre;
                pre = curr;
                curr = next;
                cnt++;
            }else{
                if(flag){
                    newHead = curr;
                    flag = false;
                }
                cnt=1;
                last.next = next;

            }
        }
        return null;

    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);
        ListNode temp = head;
        for (int i = 1; i <= 6; i++) {
            ListNode newList = new ListNode(i);
            temp.next = newList;
            temp = temp.next;
        }

        head = reveser(head,3);

        while(head.next!=null){
            System.out.println(head.val);
            head = head.next;
        }
    }
}
