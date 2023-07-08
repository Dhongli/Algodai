package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 领扣21题，合并两个有序链表
 * @date 2023/7/8 22:52
 */
public class LeetCode21 {

    /**
     * @description: 双指针，思路类似拉链
     * @param: list1
     * @param: list2
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/8 22:53
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode s = new ListNode(-1, null), p1 = list1, p2 = list2, p = s;
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
        if (p1 != null) {
            p.next = p1;
        } else {
            p.next = p2;
        }
        return s.next;
    }

    /**
     * @description: 递归实现
     * @param: list1
     * @param: list2
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/8 23:01
     */
    public ListNode mergeTwoListsV2(ListNode list1, ListNode list2) {
        if (list1 == null ) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode p = null;
        if (list1.val < list2.val) {
            p = list1;
            p.next = mergeTwoListsV2(list1.next, list2);
        } else {
            p = list2;
            p.next = mergeTwoListsV2(list1, list2.next);
        }

        return p;
    }
}
