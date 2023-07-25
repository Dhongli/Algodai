package com.dai.algo.algorithm.game;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 103. 二叉树的锯齿形层序遍历  https://leetcode.cn/problems/binary-tree-zigzag-level-order-traversal/
 * @date 2023/7/25 21:49
 */
public class LeetCode103 {
    public static void main(String[] args) {
        zigzagLevelOrder(null);
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true;
        int num = 1;
        while (!queue.isEmpty()) {
            int c = 0;
            LinkedList<Integer> deque = new LinkedList<>();
            for (int i = 0; i < num; i++) {
                TreeNode curr = queue.poll();
                if (leftToRight) {
                    deque.offerLast(curr.val);
                } else {
                    deque.offerFirst(curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                    c++;
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                    c++;
                }
            }
            result.add(deque);
            leftToRight = !leftToRight;
            num = c;
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}