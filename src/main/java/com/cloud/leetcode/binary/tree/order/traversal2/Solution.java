package com.cloud.leetcode.binary.tree.order.traversal2;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        List<List<Integer>> resultList = new ArrayList<>();
        resultList.add(Collections.singletonList(root.val));
        while (!stack.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<>();
            for (TreeNode node : stack) {
                if (node.left != null) {
                    tempStack.add(node.left);
                }
                if (node.right != null) {
                    tempStack.add(node.right);
                }
            }
            stack.clear();
            if (!tempStack.isEmpty()) {
                stack.addAll(tempStack);
                resultList.add(tempStack.stream().map(node -> node.val).collect(Collectors.toList()));
            }
        }
        Collections.reverse(resultList);
        return resultList;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode head = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));

        List<List<Integer>> result = solution.levelOrderBottom(head);

        Preconditions.checkArgument(result.size() == 3);
        Preconditions.checkArgument(result.get(0).get(0) == 15);
        Preconditions.checkArgument(result.get(0).get(1) == 7);
        Preconditions.checkArgument(result.get(1).get(0) == 9);
        Preconditions.checkArgument(result.get(1).get(1) == 20);
        Preconditions.checkArgument(result.get(2).get(0) == 3);
    }
}
