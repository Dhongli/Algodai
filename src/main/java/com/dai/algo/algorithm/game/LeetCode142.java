package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 142. 环形链表 II  https://leetcode.cn/problems/linked-list-cycle-ii/
 * @date 2023/7/9 14:29
 */
public class LeetCode142 {

    /**
     * @description: 没啥好说的，看黑马解析吧。。。。。。https://www.bilibili.com/video/BV1Lv4y1e7HL?p=88&vd_source=d26be426bd9457e105b91714951ea2d8
     * @param: head
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/9 15:20
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p1 = head, p2 = head;
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
            if (p1 == p2) {
                p1 = head;
                break;
            }
        }
        if (p2 == null || p2.next == null) {
            return null;
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
