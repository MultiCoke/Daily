package com.leetcode.simple;

import javax.swing.*;

public class S206 {
    /*
    206. 反转链表
    反转一个单链表。

    示例:

    输入: 1->2->3->4->5->NULL
    输出: 5->4->3->2->1->NULL
     */
    public static void main(String[] args) {

    }

    //  迭代法
    public  static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;
        ListNode cru = head;
        while(cru != null){
            temp = cru.next;
            cru.next = prev;
            prev = cru;
            cru = temp;
        }
        return prev;
    }

    //  递归法
    public static ListNode reverseList1(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = reverseList1(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

}