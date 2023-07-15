package com.dai.algo.algorithm.game.leetModel;

/**
 * @author Daihongli <1215765236@qq.com>
 * @version 1.0
 * @description: 力扣实体类，二叉树
 * @date 2023/7/14 21:49
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
