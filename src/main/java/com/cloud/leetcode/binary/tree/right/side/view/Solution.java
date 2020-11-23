package com.cloud.leetcode.binary.tree.right.side.view;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<Integer> resultList = new ArrayList<>();
        resultList.add(root.val);
        while (!stack.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<>();
            for (TreeNode node : stack) {
                if (node.right != null) {
                    tempStack.add(node.right);
                    resultList.add(node.right.val);
                }
            }
            stack.clear();
            if (!tempStack.isEmpty()) {
                stack.addAll(tempStack);
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        TreeNode head = TreeNode.buildTree(Arrays.asList(1, 2, 3, null, 5, null, 4));
        Solution solution = new Solution();

        List<Integer> result = solution.rightSideView(head);
        Preconditions.checkArgument(result.size() == 3);
        Preconditions.checkArgument(result.get(0) == 1);
        Preconditions.checkArgument(result.get(1) == 3);
        Preconditions.checkArgument(result.get(2) == 4);
    }
}
