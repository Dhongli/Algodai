package com.dai.algo.datastruct.queue;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: LeetCode622 设计环形队列
 * @date 2023/7/15 12:11
 */
public class MyCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        // 设置长度为 3
        circularQueue.enQueue(1);
        // 返回 true
        circularQueue.enQueue(2);
        // 返回 true
        circularQueue.enQueue(3);
        // 返回 true
        circularQueue.enQueue(4);
        // 返回 false，队列已满
        circularQueue.Rear();
        // 返回 3
        circularQueue.isFull();
        // 返回 true
        circularQueue.deQueue();
        // 返回 true
        circularQueue.enQueue(4);
        // 返回 true
        circularQueue.Rear(); // 返回 4
    }

    int[] element;

    int head;

    int tail;

    int capacity;

    // int size;

    public MyCircularQueue(int k) {
        capacity = k + 1;
        // size = 0;
        element = new int[k + 1];
    }

    /**
     * @description: 向循环队列插入一个元素。如果成功插入则返回真。
     * @param: value
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/15 12:16
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        element[tail] = value;
        tail = (tail + 1) % capacity;
        return true;
    }

    /**
     * @description: 从循环队列中删除一个元素。如果成功删除则返回真。
     * @param:
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/15 12:18
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % capacity;
        return true;
    }

    /**
     * @description: 从队首获取元素。如果队列为空，返回 -1
     * @param:
     * @return: int
     * @author daihongli
     * @date: 2023/7/15 12:22
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return element[head];
    }

    /**
     * @description: 获取队尾元素。如果队列为空，返回 -1
     * @param:
     * @return: int
     * @author daihongli
     * @date: 2023/7/15 12:25
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        if (tail == 0) {
           return element[capacity - 1];
        }
        return element[tail - 1];
    }

    /**
     * @description: 检查循环队列是否为空
     * @param:
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/15 12:28
     */
    public boolean isEmpty() {
        return head == tail;
    }

    /**
     * @description: 检查循环队列是否已满
     * @param:
     * @return: boolean
     * @author daihongli
     * @date: 2023/7/15 12:29
     */
    public boolean isFull() {
        return (tail + 1) % capacity == head;
    }
}
