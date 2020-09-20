package com.cloud.leetcode.maximum.depth.of.binary.tree;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public int maxDepth(TreeNode root) {
        if (root != null) {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<Integer> list = Arrays.asList(3, 9, 20, null, null, 15, 7);
        TreeNode head = TreeNode.buildTree(list);
        Preconditions.checkArgument(solution.maxDepth(head)==3);
    }
}
