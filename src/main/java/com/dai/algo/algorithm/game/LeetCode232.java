package com.dai.algo.algorithm.game;

import java.util.LinkedList;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 232. 用栈实现队列  https://leetcode.cn/problems/implement-queue-using-stacks/
 * @date 2023/7/23 22:03
 */
public class LeetCode232 {


}

class MyQueue {

    /**
     * @description: 队首
     */
    LinkedList<Integer> stack1 = new LinkedList<>();
    /**
     * @description: 队尾
     */
    LinkedList<Integer> stack2 = new LinkedList<>();

    public MyQueue() {

    }

    /**
     * @description: 将元素 x 推到队列的末尾
     * @param: x
     * @return: void
     * @author daihongli
     * @date: 2023/7/23 22:08
     */
    public void push(int x) {
        stack2.push(x);
    }

    /**
     * @description: 从队列的开头移除并返回元素
     * @param:
     * @return: int
     * @author daihongli
     * @date: 2023/7/23 22:08
     */
    public int pop() {
        if (empty()) {
            return -1;
        }
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.pop();
    }

    public int peek() {
        if (empty()) {
            return -1;
        }
        if (stack1.isEmpty()) {
            while (!stack2.isEmpty()) {
                stack1.push(stack2.pop());
            }
        }
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}