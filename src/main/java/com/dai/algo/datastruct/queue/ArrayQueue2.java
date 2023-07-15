package com.dai.algo.datastruct.queue;

import com.dai.algo.algorithm.game.leetModel.TreeNode;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: TODO
 * @date 2023/7/14 23:48
 */
public class ArrayQueue2 {
    public Integer[] element;
    public int head;
    public int tail;
    public int capacity = 2;
    public int size;

    public ArrayQueue2() {
        element = new Integer[capacity];
        head = 0;
        tail = 0;
        size = 0;
    }

    public int poll() {
        if (isEmpty()) {
            return 0;
        }
        int treeNode = element[head];
        head = head + 1;
        size--;
        return treeNode;
    }


    public void offer(Integer node) {
        if (node == null) return;
        if (isFull()) {
            kuorong();
        }
        element[tail] = node;
        tail = tail + 1;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }


    private void kuorong() {
        capacity = capacity << 1;
        Integer[] elementNew = new Integer[capacity];
        for (int i = 0; i < size; i++) {
            elementNew[i] = element[i];
        }
        element = elementNew;
    }
}