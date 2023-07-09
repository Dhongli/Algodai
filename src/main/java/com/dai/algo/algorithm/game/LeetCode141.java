package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 141题 环形链表  https://leetcode.cn/problems/linked-list-cycle/
 * @date 2023/7/9 14:02
 */
public class LeetCode141 {

    /**
     * @description: 快慢指针，看两个指针是否相遇，相遇则是环
     * @param: head
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/9 14:18
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p1 = head, p2 = head;
        while (p2 != null || p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                return true;
            }
        }
        return false;
    }
}
