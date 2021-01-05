package com.dai.algo.erchashu;

import java.util.LinkedList;
import java.util.Queue;

public class MinDepth {


    // 深度优先,递归
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int minDp = Integer.MAX_VALUE;
        if (root.left != null) {
            minDp = Math.min(minDp, minDepth(root.left));
        }
        if (root.right != null) {
            minDp = Math.min(minDp, minDepth(root.right));
        }
        return minDp + 1;
    }

    // 广度优先
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int mindp = 1;
        while (queue != null) {
            // 广度优先,保证每层的节点每次都判断到
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode nodDep = queue.poll();
                if (nodDep.left == null && nodDep.right == null) {
                    return mindp;
                }
                if (nodDep.left != null) {
                    queue.offer(nodDep.left);
                }
                if (nodDep.right != null) {
                    queue.offer(nodDep.right);
                }
            }
            mindp++;
        }
        return mindp;
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