package com.dai.algo.algorithm.game;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @date 2023/7/6 22:05
 */
public class LeetCode206 {
    public static void main(String[] args) {
        ListNode o5 = new ListNode(5, null);
        ListNode o4 = new ListNode(4, o5);
        ListNode o3 = new ListNode(3, o4);
        ListNode o2 = new ListNode(2, o3);
        ListNode o1 = new ListNode(1, o2);
        listPrint(o1);
        ListNode listNode = reversList1(o1);
        listPrint(listNode);
        listPrint(reversList2(listNode));
    }
    public static void listPrint(ListNode node) {
        for (ListNode curr = node; curr != null; curr = curr.next) {
            System.out.print(curr.val);
            System.out.print("\t");
        }
        System.out.println();
    }
    /**
     * @description: 递归实现  递的时候由前到后记录每个节点到最后节点，归的时候先返回最后的节点，每归一层当层节点放到当层节点的next的后面
     * @param: first
     * @return: void
     * @author daihongli
     * @date: 2023/7/6 22:08
     */
    public static ListNode reversList1(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        // 至最深层后会将链表最后一个节点返回回来，每层递归都返回这个last（这是反转后的头节点）
        ListNode last = reversList1(node.next);
        // 将当前层节点放到后面节点的后面（每层都这么干，实现惊天大反转）
        node.next.next = node;
        // 敲黑板！ 特别注意，这块如果不设为null，最后一次到初始的1节点后，1节点还是指向的初始2节点，导致旧的1、2节点闭环
        node.next = null;
        return last;
    }

    /**
     * @description: 设置三个指针，首节点前 per、 首节点 mid、 首节点后end, 循环每循环一次三个指针向后移动一位，并且mid所指节点的next指向per
     * @param: node
     * @return: com.dai.algo.algorithm.game.ListNode
     * @author daihongli
     * @date: 2023/7/6 22:36
     */
    public static ListNode reversList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode per = null;
        ListNode mid = head;
        ListNode end = head.next;
        while (true) {
            mid.next = per;
            if (end == null) {
                return mid;
            }
            per = mid;
            mid = end;
            end = mid.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}