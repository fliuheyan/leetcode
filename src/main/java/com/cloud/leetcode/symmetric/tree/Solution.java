package com.cloud.leetcode.symmetric.tree;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.Arrays;
import java.util.LinkedList;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        LinkedList<TreeNode> leftToRight = new LinkedList<>();
        LinkedList<TreeNode> rightToLeft = new LinkedList<>();
        TreeNode leftCurr = null;
        TreeNode rightCurr = null;
        leftToRight.push(root);
        rightToLeft.push(root);
        while (!leftToRight.isEmpty() && !rightToLeft.isEmpty()) {
            leftCurr = leftToRight.pop();
            rightCurr = rightToLeft.pop();
            if (leftCurr.val != rightCurr.val) return false;
            if ((leftCurr.left == null && null != rightCurr.right)
                    || (rightCurr.right == null && leftCurr.left != null)) {
                return false;
            }
            if (leftCurr.left != null) {
                leftToRight.push(leftCurr.left);
                rightToLeft.push(rightCurr.right);
            }
            if ((rightCurr.left == null && leftCurr.right != null) ||
                    (rightCurr.left != null & leftCurr.right == null)) {
                return false;
            }
            if (leftCurr.right != null) {
                leftToRight.push(leftCurr.right);
                rightToLeft.push(rightCurr.left);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode head1 = TreeNode.buildTree(Arrays.asList(1, 2, 2, 3, 4, 4, 3));
        Preconditions.checkArgument(solution.isSymmetric(head1));

        TreeNode head2 = TreeNode.buildTree(Arrays.asList(1, 2, 2, null, 3, null, 3));
        Preconditions.checkArgument(!solution.isSymmetric(head2));
    }
}
