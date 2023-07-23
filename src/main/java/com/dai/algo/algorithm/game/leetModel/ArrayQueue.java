package com.dai.algo.algorithm.game.leetModel;

import java.util.LinkedList;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: TODO
 * @date 2023/7/23 22:00
 */
public class ArrayQueue {
    TreeNode[] element;
    LinkedList<TreeNode> list = new LinkedList<>();
    int head;
    int tail;
    int capacity = 2;
    int size;

    public ArrayQueue() {
        element = new TreeNode[capacity + 1];
        head = 0;
        tail = 0;
        size = 0;
    }

    public TreeNode poll() {
        if (isEmpty()) {
            return null;
        }
        TreeNode treeNode = element[head];
        // head = (head + 1) % element.length;
        head = head + 1;
        size--;
        return treeNode;
    }


    public void offer(TreeNode node) {
        if (node == null) return;
        if (isFull()) {
            kuorong();
        }
        element[tail] = node;
        // tail = (tail + 1) % element.length;
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
        TreeNode[] elementNew = new TreeNode[capacity];
        for (int i = 0; i < size; i++) {
            elementNew[i] = element[i];
        }
        element = elementNew;
    }
}