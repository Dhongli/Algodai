package com.dai.algo.algorithm.game.leetModel;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 力扣定义的实体类，单项链表节点定义
 * @date 2023/7/7 9:35
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(ListNode next) {
        this.val = val;
        this.next = next;
    }
}
