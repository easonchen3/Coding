package com.baiguo.other.leetcode.array;

/**
 * @Author: BaoJian.Xu
 * @Date: 2019-07-20 14:26
 * @Version 1.0
 */
public class MyLinkedList {
    private Node fisrt;
    private Node last;
    private int size;

    public void add(Object obj){
        Node node = new Node();

        //链表一开始是空的情况
        if(fisrt==null){
            node.prev = null;
            node.next = null;
            node.setObj(obj);
            fisrt = node;
            last = node;
        }else{
            //当第一个节点存在，直接王后面关联
            node.prev = last;
            node.next = null;
            node.setObj(obj);
            last.next = node;
            last = node;
        }
    }


    private static class Node{
        Object obj;

        Node prev;

        Node next;

        public Node(Object obj,Node prev,Node next){
            this.obj = obj;
            this.prev = prev;
            this.next = next;
        }

        public Node(){}

        public void setObj(Object obj){
            this.obj = obj;
        }
    }
}
