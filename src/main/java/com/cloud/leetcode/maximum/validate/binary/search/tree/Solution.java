package com.cloud.leetcode.maximum.validate.binary.search.tree;

import com.cloud.leetcode.helper.ListNode;
import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            if (curr.left != null) {
                if (curr.left.val < curr.val) {
                    stack.push(curr.left);
                } else {
                    return false;
                }
            }
            if (curr.right != null) {
                if (curr.right.val > curr.val) {
                    stack.push(curr.right);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode head = TreeNode.buildTree(Arrays.asList(5, 1, 4, null, null, 3, 6));

        Preconditions.checkArgument(!solution.isValidBST(head));

        TreeNode head1 = TreeNode.buildTree(Arrays.asList(5, 1, 4, null, null, 3, 6));

        Preconditions.checkArgument(!solution.isValidBST(head1));
    }
}
