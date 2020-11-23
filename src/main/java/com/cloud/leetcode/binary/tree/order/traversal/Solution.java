package com.cloud.leetcode.binary.tree.order.traversal;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
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
            if (!temp.isEmpty()) {
                result.add(temp.stream().map(node -> node.val).collect(Collectors.toList()));
                stack.addAll(temp);
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        //先将head加入stack当中
        stack.push(root);
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.singletonList(root.val));
        //每次遍历一层
        while (!stack.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<>();
            List<Integer> tempList = new ArrayList<>();
            //先遍历stack，同时将当前层中的所有children加入到tempStack当中
            //当前层的值加入到tempList
            for (TreeNode node : stack) {
                if (node.left != null) {
                    tempStack.add(node.left);
                    tempList.add(node.left.val);
                }
                if (node.right != null) {
                    tempStack.add(node.right);
                    tempList.add(node.right.val);
                }
            }
            //如果当前层有值，加入result中
            if (!tempList.isEmpty())
                result.add(tempList);
            //清空stack,同时将当前层的所有children
            stack.clear();
            stack.addAll(tempStack);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode head = TreeNode.buildTree(Arrays.asList(3, 9, 20, null, null, 15, 7));

        List<List<Integer>> result = solution.levelOrder2(head);

        Preconditions.checkArgument(result.size() == 3);
        Preconditions.checkArgument(result.get(0).get(0) == 3);
        Preconditions.checkArgument(result.get(1).get(0) == 9);
        Preconditions.checkArgument(result.get(1).get(1) == 20);
        Preconditions.checkArgument(result.get(2).get(0) == 15);
        Preconditions.checkArgument(result.get(2).get(1) == 7);
    }
}
