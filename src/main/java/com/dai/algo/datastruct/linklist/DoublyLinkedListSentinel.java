package com.dai.algo.datastruct.linklist;

import java.util.Iterator;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 带哨兵的双向链表
 * @date 2023/7/1 21:19
 */
public class DoublyLinkedListSentinel implements Iterable<Integer> {

    private Node head;
    private Node tail;

    public DoublyLinkedListSentinel() {
        this.head = new Node(null, null, Integer.MAX_VALUE);
        this.tail = new Node(null, null, Integer.MIN_VALUE);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    /**
     * @description: 获取指定位置元素值
     * @param: index
     * @return: int
     * @author daihongli
     * @date: 2023/7/1 22:57
     */
    public int get(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw illegalIndex(index);
        }
        return node.value;
    }

    /**
     * @description: 找到第一个元素
     * @param:
     * @return: int
     * @author daihongli
     * @date: 2023/7/1 23:10
     */
    public int getFirst() {
        Node node = head.next;
        if (node == tail) {
            throw illegalIndex(0);
        }
        return node.value;
    }

    public int getLast() {
        Node node = tail.prev;
        if (node == head) {
            throw illegalIndex(0);
        }
        return node.value;
    }

    /**
     * @description: 在索引 index 处插入值 value
     * @param: index 从0开始
     * @param: value
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 22:00
     */
    public void insert(int index, int value) {
        // 此处传 index - 1 防止 传index 返回 null 时无法判断是否为tail
        Node prev = findNode(index - 1);
        if (prev == null) {
            throw illegalIndex(index);
        }
        Node next = prev.next;
        Node inserted = new Node(prev, next, value);
        prev.next = inserted;
        next.prev = inserted;
    }

    /**
     * @description: 首位添加元素
     * @param: value
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 22:46
     */
    public void addFirst(int value) {
        insert(0, value);
    }

    /**
     * @description: 首位移除元素
     * @param:
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 22:46
     */
    public void removeFirst() {
        remove(0);
    }

    /**
     * @description: 末尾添加元素
     * @param: value
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 22:45
     */
    public void addLast(int value) {
        Node prev = tail.prev;
        Node node = new Node(prev, tail, value);
        prev.next = node;
        tail.prev = node;
    }

    /**
     * @description: 移除最后位置元素
     * @param:
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 22:45
     */
    public void removeLast() {
        Node node = tail.prev;
        if (node == head) {
            throw illegalIndex(0);
        }
        Node prev = node.prev;
        prev.next = tail;
        tail.prev = prev;
    }

    /**
     * @description: 根据索引移除 node
     * @param: index 从0开始
     * @return: void
     * @author daihongli
     * @date: 2023/7/1 22:11
     */
    public void remove(int index) {
        Node node = findNode(index);
        // 不可移除首尾哨兵
        if (node == null) {
            throw illegalIndex(index);
        }
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }

    /**
     * @description: 根据索引找 node, index 为 tail 位置时返回 null
     * @param: index
     * @return: Node
     * @author daihongli
     * @date: 2023/7/1 21:54
     */
    private Node findNode(int index) {
        int i = -1;
        for (Node curr = head; curr != tail; i++, curr = curr.next) {
            if (i == index) {
                return curr;
            }
        }
        return null;
    }

    private IllegalArgumentException illegalIndex(int index) {
        return new IllegalArgumentException(
                String.format("index [%d] 不合法%n", index));
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
            Node curr = head.next;
            @Override
            public boolean hasNext() {
                return curr != tail;
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
