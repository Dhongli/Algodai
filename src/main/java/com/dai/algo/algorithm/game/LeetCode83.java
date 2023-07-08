package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 删除排序链表中的重复元素
 * @date 2023/7/7 22:49
 */
public class LeetCode83 {

    public ListNode deleteDuplicates(ListNode head) {
        deleteElement(head);
        return head;
    }

    /**
     * @description: 递归删除
     * @param: head
     * @return: int
     * @author daihongli
     * @date: 2023/7/7 23:04
     */
    private int deleteElement(ListNode head) {
        if (head == null) {
            return -101;
        }
        int nextValue = deleteElement(head.next);
        if (head.val == nextValue) {
            head.next = head.next.next;
        }
        return head.val;
    }

    /**
     * @description: 双指针法
     * @param: head
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/8 8:42
     */
    public ListNode deleteDuplicatesV2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p1 = head, p2 = head.next;
        while (p2 != null) {
            if (p1.val == p2.val) {
                p2.next = null;
                p2 = p1.next;
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return head;
    }

}
