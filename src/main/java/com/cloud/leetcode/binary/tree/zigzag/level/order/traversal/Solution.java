package com.cloud.leetcode.binary.tree.zigzag.level.order.traversal;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        stack.push(root);
        result.add(Collections.singletonList(root.val));
        boolean order = false;
        while (!stack.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<>();
            for (TreeNode current : stack) {
                if (order) {
                    if (current.left != null) {
                        tempStack.add(current.left);
                    }
                    if (current.right != null) {
                        tempStack.add(current.right);
                    }
                } else {
                    if (current.right != null) {
                        tempStack.add(current.right);
                    }
                    if (current.left != null) {
                        tempStack.add(current.left);
                    }
                }
            }
            stack.clear();
            if (!tempStack.isEmpty()) {
                stack.addAll(tempStack);
                result.add(tempStack.stream().map(node -> node.val).collect(Collectors.toList()));
            }
            order = !order;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode head = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));
        Solution solution = new Solution();
        List<List<Integer>> result = solution.zigzagLevelOrder(head);

        Preconditions.checkArgument(result.size() == 3);
        Preconditions.checkArgument(result.get(0).get(0) == 3);
        Preconditions.checkArgument(result.get(1).get(0) == 20);
        Preconditions.checkArgument(result.get(1).get(1) == 9);
        Preconditions.checkArgument(result.get(2).get(0) == 15);
        Preconditions.checkArgument(result.get(2).get(1) == 7);
    }
}
