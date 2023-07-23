package com.dai.algo.algorithm.game;

import com.dai.algo.algorithm.game.leetModel.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 102. 二叉树的层序遍历  https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @date 2023/7/14 22:02
 */
public class LeetCode102 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        extracted(root, 2, 3);
        extracted(root.left, 4, 5);
        extracted(root.right, 6, 7);
        extracted(root.left.left, 8, 9);
        extracted(root.left.right, 10, 11);
        extracted(root.right.left, 12, 13);
        extracted(root.right.right, 14, 15);

        levelOrder(root);
    }

    private static void extracted(TreeNode root, int valL, int valR) {
        root.left = new TreeNode(valL);
        root.right = new TreeNode(valR);
    }

    /**
     * @description: 本想自己实现数组类型队列，但此问题树的长度不确定，所以还是用LinkedList
     * @param: root
     * @return: java.util.List<java.util.List < java.lang.Integer>>
     * @author daihongli
     * @date: 2023/7/15 8:33
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) return lists;
        // ArrayQueue queue = new ArrayQueue();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                TreeNode parent = queue.poll();
                if (parent.left != null)
                    queue.offer(parent.left);
                if (parent.right != null)
                    queue.offer(parent.right);
                list.add(parent.val);
            }
            lists.add(list);
        }
        return lists;
    }
}

