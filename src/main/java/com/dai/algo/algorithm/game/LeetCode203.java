package com.dai.algo.algorithm.game;

import java.util.List;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * @date 2023/7/7 9:32
 */
public class LeetCode203 {
    public static void main(String[] args) {
        ListNode o6 = new ListNode(6, null);
        ListNode o5 = new ListNode(4, o6);
        ListNode o4 = new ListNode(3, o5);
        ListNode o3 = new ListNode(6, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        listPrint(o1);
        ListNode listNode = removeElementsV3(o1, 6);
        listPrint(listNode);
    }

    /**
     * @description: 不带哨兵的链表，要对head处理，很麻烦
     * @param: head
     * @param: val
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/7 9:43
     */
    public static ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            ListNode next = head.next;
            head.next = null;
            head = next;
        }
        if (head == null) {
            return head;
        }
        ListNode per = head;
        ListNode p2 = head.next;
        while (p2 != null) {
            if (p2.val == val) {
                per.next = p2.next;
                p2 = per.next;
            } else {
                per = p2;
                p2 = p2.next;
            }
        }
        return head;
    }

    /**
     * @description: 带哨兵
     * @param: head
     * @param: val
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/7 12:04
     */
    public static ListNode removeElementsV2(ListNode head, int val) {
        ListNode senternal = new ListNode(-1, head);
        ListNode per = senternal;
        ListNode p2 = head;
        while (p2 != null) {
            if (p2.val == val) {
                per.next = p2.next;
                p2 = p2.next;
            } else {
                per = p2;
                p2 = per.next;
            }
        }
        return senternal.next;
    }


    /**
     * @description: 牛B的递归，老子自己想出来的递归
     * @param: head
     * @param: val
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/7 16:59
     */
    public static ListNode removeElementsV3(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        head.next = removeElementsV3(head.next, val);
        // if (head.next != null && head.next.val == val) {
        //     head.next = next;
        // }
        if (head.val == val) {
            return head.next;
        }
        return head;
    }

    /**
     * @description: 黑马课的递归，也很牛B，但没我的快。。。
     * @param: head
     * @param: val
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/7 17:00
     */
    public ListNode removeElements5(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return removeElements(head.next, val);
        } else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }

    public static void listPrint(ListNode node) {
        for (ListNode curr = node; curr != null; curr = curr.next) {
            System.out.print(curr.val);
            System.out.print("\t");
        }
        System.out.println();
    }
}


