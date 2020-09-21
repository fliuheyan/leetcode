package com.cloud.leetcode.binary.tree.order.traversal;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        result.add(List.of(root.val));
        stack.push(root);
        while (!stack.isEmpty()) {
            List<TreeNode> temp = new ArrayList<>();
            for (TreeNode node : stack) {
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            stack.clear();
            if(!temp.isEmpty()) {
                result.add(temp.stream().map(node -> node.val).collect(Collectors.toList()));
                stack.addAll(temp);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode head = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));

        List<List<Integer>> result = solution.levelOrder(head);

        Preconditions.checkArgument(result.size() == 3);
        Preconditions.checkArgument(result.get(0).get(0) == 3);
        Preconditions.checkArgument(result.get(1).get(0) == 9);
        Preconditions.checkArgument(result.get(1).get(1) == 20);
        Preconditions.checkArgument(result.get(2).get(0) == 15);
        Preconditions.checkArgument(result.get(2).get(1) == 7);
    }
}
