package com.ceshiren.sorting;

import java.util.ArrayList;

/**
 * @Author chenqiang
 * @create 2023/11/15 16:28
 */
public class ReverseList {
    public static class ListNode{
        int val;
        public ListNode next;

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }

        public ListNode() {
        }
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    // 递归算法反转连表
    public static ListNode reverseList1(ListNode head){
        if(head ==null||head.next==null){
            return head;
        }
        ListNode prev = reverseList1(head.next);
        head.next.next = head;
        head.next=null;
        return prev;
    }
    public static ListNode reverseList2(ListNode head){
        if(head==null||head.next==null){
            return head;
        }
        ListNode prev=null;
        ListNode temp=head;
        ListNode next;
        while (temp!=null){
            next = temp.next;
            temp.next=prev;
            prev=temp;
            temp=next;
        }
        return prev;
    }

    private static void print(ListNode head){
        while(head != null){
            System.out.println(head.getVal() + " " + head.getClass().getName());
            head = head.next;
        }
    }

    public static ArrayList<ListNode> arrayList(int n){
        ArrayList<ListNode> arrayList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            ListNode node = new ListNode();
            node.setVal(i);
            arrayList.add(node);
            if(i!=1){
                arrayList.get(i-2).setNext(arrayList.get(i-1));
            }
            if (i==n) {
                arrayList.get(i - 1).setNext(null);
            }
        }
        return arrayList;
    }
    public static void main(String[] args) {
        ListNode head ;
        ArrayList<ListNode> arrayList = arrayList(5);
        head= arrayList.get(0);
        print(head);
        System.out.println("--------------------");
        ListNode reverseList2 = reverseList2(head);
        print(reverseList2);
        System.out.println("--------------------");
        ArrayList<ListNode> arrayList1 = arrayList(5);
        head = arrayList1.get(0);
        ListNode reverseList1 = reverseList1(head);
        print(reverseList1);

    }
}
