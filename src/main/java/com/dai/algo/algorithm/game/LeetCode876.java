package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 876. 链表的中间结点  https://leetcode.cn/problems/middle-of-the-linked-list/
 * @date 2023/7/9 10:23
 */
public class LeetCode876 {

    /**
     * @description: 双指针，快慢指针，慢指针走一步快指针走两步
     * @param: head
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/9 10:32
     */
    public ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}
