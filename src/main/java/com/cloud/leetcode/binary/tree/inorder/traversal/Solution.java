package com.cloud.leetcode.binary.tree.inorder.traversal;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> inorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        if (root.left != null) result.addAll(inorderTraversalRecursive(root.left));
        result.add(root.val);
        if (root.right != null) result.addAll(inorderTraversalRecursive(root.right));
        return result;
    }

    public List<Integer> inorderTraversalLoop(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        List<Integer> result = new ArrayList<>();
        TreeNode current = root;
        while (current.left != null) {
            stack.push(current.left);
        }
        while (!stack.isEmpty()) {
            
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        TreeNode head1 = TreeNode.buildTree(Arrays.asList(1, null, 2, null, null, 3));
        List<Integer> result1 = solution.inorderTraversalRecursive(head1);
        Preconditions.checkArgument(result1.size() == 3);
        Preconditions.checkArgument(result1.get(0) == 1);
        Preconditions.checkArgument(result1.get(1) == 3);
        Preconditions.checkArgument(result1.get(2) == 2);

        TreeNode head2 = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, null, null, 5, null, 6));
        List<Integer> result2 = solution.inorderTraversalRecursive(head2);
        Preconditions.checkArgument(result2.size() == 6);
        Preconditions.checkArgument(result2.get(0) == 4);
        Preconditions.checkArgument(result2.get(1) == 6);
        Preconditions.checkArgument(result2.get(2) == 2);
        Preconditions.checkArgument(result2.get(3) == 1);
        Preconditions.checkArgument(result2.get(4) == 3);
        Preconditions.checkArgument(result2.get(5) == 5);

        TreeNode head3 = TreeNode.buildTree(Arrays.asList(1, null, 2, null, null, 3));
        List<Integer> result3 = solution.inorderTraversalLoop(head3);
        Preconditions.checkArgument(result3.size() == 3);
        Preconditions.checkArgument(result3.get(0) == 1);
        Preconditions.checkArgument(result3.get(1) == 3);
        Preconditions.checkArgument(result3.get(2) == 2);

        TreeNode head4 = TreeNode.buildTree(Arrays.asList(1, 2, 3, 4, null, null, 5, null, 6));
        List<Integer> result4 = solution.inorderTraversalRecursive(head4);
        Preconditions.checkArgument(result4.size() == 6);
        Preconditions.checkArgument(result4.get(0) == 4);
        Preconditions.checkArgument(result4.get(1) == 6);
        Preconditions.checkArgument(result4.get(2) == 2);
        Preconditions.checkArgument(result4.get(3) == 1);
        Preconditions.checkArgument(result4.get(4) == 3);
        Preconditions.checkArgument(result4.get(5) == 5);
    }
}
