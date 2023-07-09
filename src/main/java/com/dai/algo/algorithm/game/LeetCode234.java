package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 234. 回文链表 https://leetcode.cn/problems/palindrome-linked-list/
 * @date 2023/7/9 11:20
 */
public class LeetCode234 {

    /**
     * @description: 双指针，技巧是找到中点，反转中点到后面的链表，然后比较中点之前的链表与反转链表
     * @param: head
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/9 11:26
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode midNode = findMid(head);
        ListNode node = reversList(midNode);
        while (node != null) {
            if (head.val != node.val) {
                return false;
            }
            head = head.next;
            node = node.next;
        }
        return true;
    }


    /**
     * @description: 反转链表
     * @param: s
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/9 11:38
     */
    private ListNode reversList(ListNode node) {
        ListNode cur = node, per = null;
        while (cur != null) {
            ListNode n = cur.next;
            cur.next = per;
            per = cur;
            cur = n;
        }
        return per;
    }

    /**
     * @description: 找到链表中间的节点, 快慢指针，慢指针走一步，快指针走两步
     * @param: head
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/9 11:38
     */
    private ListNode findMid(ListNode head) {
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        if (p2 != null) {
            return p1.next;
        }
        return p1;
    }

    /**
     * @description: 优化，在第一个基础上，快慢指针遍历时就将前半部分反转，遍历结束后再遍历前后半段链表进行比较
     * @param: head
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/9 13:32
     */
    public boolean isPalindromeV2(ListNode head) {
        ListNode p1 = head, p2 = head; // 快慢指针
        ListNode per = null, curr = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            // ListNode node = curr.next;
            curr.next = per;
            per = curr;
            curr = p1;
        }
        if (p2 != null) {
            p1 = p1.next;
        }
        while (per != null) {
            if (per.val != p1.val) {
                return false;
            }
            per = per.next;
            p1 = p1.next;
        }
        return true;
    }
}
