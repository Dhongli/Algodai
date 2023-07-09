package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 合并K个升序链表 https://leetcode.cn/problems/merge-k-sorted-lists/description/
 * @date 2023/7/9 8:34
 */
public class LeetCode23 {

    /**
     * @description: 运用递归，将链表数组拆成单个链表，归时两两合并
     * @param: lists
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/9 8:38
     */
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }


    public ListNode merge(ListNode[] lists, int i, int j) {
        if (j == -1) return null;
        if (i == j) {
            return lists[i];
        }
        int m = (i + j) >>> 1;
        ListNode a = merge(lists, i, m);
        ListNode b = merge(lists, m + 1, j);
        return mergeAB(a, b);
    }

    private ListNode mergeAB(ListNode a, ListNode b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        ListNode s = new ListNode(-1);
        ListNode p = s, p1 = a, p2 = b;
        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 == null) {
           p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }
        return s.next;
    }
}
