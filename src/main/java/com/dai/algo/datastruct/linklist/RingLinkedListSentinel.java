package com.dai.algo.datastruct.linklist;

import java.util.Iterator;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 环形双向链表
 * @date 2023/7/2 7:08
 */
public class RingLinkedListSentinel implements Iterable<Integer> {

    private Node sentinel = new Node(null, null, Integer.MAX_VALUE);

    public RingLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * @description: 首位添加元素
     * @param: value
     * @return: void
     * @author daihongli
     * @date: 2023/7/2 7:16
     */
    public void addFirst(int value) {
        Node next = sentinel.next;
        Node node = new Node(sentinel, next, value);
        next.prev = node;
        sentinel.next = node;
        // if (sentinel.prev != sentinel) {
        //     return;
        // }
        // sentinel.prev = node;
    }

    /**
     * @description: 末尾添加
     * @param: value
     * @return: void
     * @author daihongli
     * @date: 2023/7/2 7:26
     */
    public void addLast(int value) {
        Node prev = sentinel.prev;
        Node node = new Node(prev, sentinel, value);
        prev.next = node;
        sentinel.prev = node;
        // if (sentinel.next != sentinel) {
        //     return;
        // }
        // sentinel.next = node;
    }

    /**
     * @description: 移除首元素
     * @param:
     * @return: void
     * @author daihongli
     * @date: 2023/7/2 7:38
     */
    public void removeFirst() {
        if (sentinel.next == sentinel) {
            throw new IllegalArgumentException("非法, 空链表");
        }
        Node removeNode = sentinel.next;
        Node next = removeNode.next;
        sentinel.next = next;
        next.prev = sentinel;
    }

    /**
     * @description: 移除末尾元素
     * @param:
     * @return: void
     * @author daihongli
     * @date: 2023/7/2 7:44
     */
    public void removeLast() {
        if (sentinel.prev == sentinel) {
            throw new IllegalArgumentException("非法, 空链表");
        }
        Node removeNode = sentinel.prev;
        Node prev = removeNode.prev;
        sentinel.prev = prev;
        prev.next = sentinel;
    }

    /**
     * @description: 通过值删除node
     * @param: value
     * @return: void
     * @author daihongli
     * @date: 2023/7/2 7:55
     */
    public void removeByValue(int value) {
        Node node = findNodeByValue(value);
        if (node != null) {
            Node next = node.next;
            Node prev = node.prev;
            prev.next = next;
            next.prev = prev;
        }
    }

    /**
     * @description: 通过元素值找元素
     * @param: value
     * @return: Node
     * @author daihongli
     * @date: 2023/7/2 7:47
     */
    private Node findNodeByValue(int value) {
        Node node = sentinel.next;
        while (node != sentinel) {
            if (node.value == value) {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    private class Node {
        Node prev;
        Node next;
        int value;

        public Node(Node prev, Node next, int value) {
            this.prev = prev;
            this.next = next;
            this.value = value;
        }
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node curr = sentinel.next;

            @Override
            public boolean hasNext() {
                return curr != sentinel;
            }

            @Override
            public Integer next() {
                int value = curr.value;
                curr = curr.next;
                return value;
            }
        };
    }
}
