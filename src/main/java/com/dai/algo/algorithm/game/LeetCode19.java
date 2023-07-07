package com.dai.algo.algorithm.game;

import java.util.List;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 删除链表的倒数第N个结点
 * @date 2023/7/7 17:41
 */
public class LeetCode19 {
    public static void main(String[] args) {
        ListNode o6 = new ListNode(6, null);
        ListNode o5 = new ListNode(4, o6);
        ListNode o4 = new ListNode(3, o5);
        ListNode o3 = new ListNode(6, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        listPrint(o1);
    }

    public static void listPrint(ListNode node) {
        for (ListNode curr = node; curr != null; curr = curr.next) {
            System.out.print(curr.val);
            System.out.print("\t");
        }
        System.out.println();
    }

    /**
     * @description: 自己的递归
     * @param: head
     * @param: n
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/7 20:59
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int i = remove(head, n);
        if (i == n) {
            head = head.next;
        }
        return head;
    }

    /**
     * @description: 黑马的小胜一筹，加哨兵了，牛逼
     * @param: head
     * @param: n
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/7 21:05
     */
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        ListNode sentinal = new ListNode(-1, head);
        remove(sentinal, n);
        return head;
    }

    private int remove(ListNode head, int n) {
        if (head == null) {
            return 0;
        }
        int next = remove(head.next, n);
        // int cur = i + 1;
        if (next == n) {
            head.next = head.next.next;
        }
        return next + 1;
    }

    /**
     * @description: 自己的双指针
     * @param: head
     * @param: n
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/7 22:04
     */
    public ListNode removeNthFromEndV3(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        ListNode p1 = head, p2 = head, per = head; // 快指针, 慢指针

        for (int i = 1; i < n; i++) {
            p1 = p1.next;
        }
        while (p1.next != null) {
            p1 = p1.next;
            per = p2;
            p2 = p2.next;
        }
        if (per == p2) { // 说明没进循环，n就是链表长度，则删除第一个
            head = head.next;
        } else {
            per.next = p2.next;
        }
        return head;
    }

    /**
     * @description: 黑马，双指针带哨兵
     * @param: head
     * @param: n
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/7 22:05
     */
    public ListNode removeNthFromEndV4(ListNode head, int n) {
        ListNode sentinal = new ListNode(-1, head);
        ListNode p1 = sentinal, p2 = sentinal;
        for (int i = 0; i < n; i++) { // 因为i从0开始，所以循环结束后p1与p2间的长度比n多1
            p1 = p1.next;
        }
        // 有哨兵，必进循环，只要head不空
        while (p1.next != null) {   // p1与p2间的长度比n多1，所以p1到最后时，p2在要删除的位置的前面
            p1 = p1.next;
            p2 = p2.next;
        }
        p2.next = p2.next.next;
        return sentinal.next;
    }
}
