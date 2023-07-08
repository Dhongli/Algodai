package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 删除排序链表中的重复元素II
 * @date 2023/7/8 17:50
 */
public class LeetCode82 {
    /**
     * @description: 递归
     * @param: head
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/8 17:51
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        if (head.val == head.next.val) {
            ListNode p = head.next.next;
            while (p != null && p.val == head.val) {
                p = p.next;
            }
            return deleteDuplicates(p);
        } else {
            head.next = deleteDuplicates(head.next);
            return head;
        }
    }

    /**
     * @description: 非递归，三个指针加哨兵
     * @param: head
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/8 18:28
     */
    public ListNode deleteDuplicatesV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinal = new ListNode(-1, head);
        ListNode p = sentinal, p1 = head, p2 = head.next;
        while (p2 != null) {
            if (p1.val == p2.val) {
                // if (p2.next == null) {
                p.next = p2.next;
                // }
                p2 = p2.next;
            } else if (p1.next != p2) {
                p.next = p2;
                p1 = p2;
                p2 = p2.next;
            } else {
                p = p1;
                p1 = p2;
                p2 = p2.next;
            }
        }
        return sentinal.next;
    }

    /**
     * @description: 非递归，三个指针加哨兵  黑马
     * @param: head
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/8 22:06
     */
    public ListNode deleteDuplicatesV3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode sentinal = new ListNode(-1, head);
        ListNode p = sentinal, p1, p2;
        while ((p1 = p.next) != null && (p2 = p1.next) != null) {
            if (p1.val == p2.val) {
                while ((p2 = p2.next) != null && p2.val == p1.val) {
                }
                p.next = p2;
            } else {
                p = p1;
            }
        }
        return sentinal.next;
    }
}
