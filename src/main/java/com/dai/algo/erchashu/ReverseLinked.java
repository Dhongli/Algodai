package com.dai.algo.erchashu;

/**
 * 206. 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseLinked {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode next2 = new ListNode(2);
        ListNode next3 = new ListNode(3);
        ListNode next4 = new ListNode(4);
        head.next = next2;
        next2.next = next3;
        next3.next = next4;
        ListNode revese = reveseList(head);
        System.out.println(revese);
        System.out.println(revese.next);
        System.out.println(revese.next.next);
        System.out.println(revese.next.next.next);
    }

    public static ListNode reveseList(ListNode head) {
        ListNode per = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode nex = cur.next;
            cur.next = per;
            per = cur;
            cur = nex;
        }
        return per;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return Integer.toString(val);
    }
}
