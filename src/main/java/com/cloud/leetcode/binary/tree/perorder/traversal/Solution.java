package com.cloud.leetcode.binary.tree.perorder.traversal;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public List<Integer> traversal(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) return result;
        result.add(head.val);
        if (head.left != null) result.addAll(traversal(head.left));
        if (head.right != null) result.addAll(traversal(head.right));
        return result;
    }

    public List<Integer> traversalLoop(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        TreeNode current = head;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(current);
        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.val);
            if (current.right != null) {
                stack.push(current.right);
            }
            if (current.left != null) {
                stack.push(current.left);
            }
        }
        return result;
    }
    /*
                                   90
                               /       \
                             50        150
                           / \       /    \
                         20  75    95     175
                       / \  /  \   / \    / \
                      5  25 66 80 92 111 166 200
     */

    public static void main(String[] args) {
        TreeNode head = TreeNode.buildTree(List.of(90, 50, 150, 20, 75, 95, 175, 5, 25, 66, 80, 92, 111, 166, 200));
        Solution solution = new Solution();

        List<Integer> result = solution.traversal(head);
        String collect = result.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        Preconditions.checkArgument(collect
                .equals("90,50,20,5,25,75,66,80,150,95,92, 111, 175, 166, 200".replace(" ", "")));


        List<Integer> result1 = solution.traversalLoop(head);
        String collect1 = result1.stream().map(String::valueOf)
                .collect(Collectors.joining(","));
        System.out.println(collect1);
        Preconditions.checkArgument(collect1
                .equals("90,50,20,5,25,75,66,80,150,95,92, 111, 175, 166, 200".replace(" ", "")));
    }
}
