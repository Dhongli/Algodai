package com.dai.algo.algorithm.game;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 225. 用队列实现栈  https://leetcode.cn/problems/implement-stack-using-queues/
 * @date 2023/7/24 21:29
 */
public class LeetCode225 {

}

/**
 * 使用两个队列实现
 */
class MyStack1 {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public MyStack1() {

    }

    /**
     * @description: 双队列实现，需要保证最后入的最先出。值先入q2,
     * 再将q1的值逐个放入q2，然后对调q1、q2。从而保证q1头部是最后入的
     * @param: x
     * @return: void
     * @author daihongli
     * @date: 2023/7/24 21:37
     */
    public void push(int x) {
        q2.add(x);
        while (!q1.isEmpty()) {
            q2.add(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public int pop() {
        return q1.poll();
    }

    public int top() {
        return q1.peek();
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * 单个队列实现
 */
class MyStack2 {
    Queue<Integer> queue = new LinkedList<>();

    public MyStack2() {

    }

    /**
     * @description:
     * @param: x
     * @return: void
     * @author daihongli
     * @date: 2023/7/24 21:37
     */
    public void push(int x) {
        queue.offer(x);
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.offer(queue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}