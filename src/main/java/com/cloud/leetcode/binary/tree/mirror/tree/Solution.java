package com.cloud.leetcode.binary.tree.mirror.tree;

import com.cloud.leetcode.helper.TreeNode;

public class Solution {
    public TreeNode mirrorTree(TreeNode root) {
        dfs(root);
        return root;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
        dfs(node.left);
        dfs(node.right);
    }
}
