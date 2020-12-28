package com.cloud.leetcode.helper;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static double log2(double N) {
        return Math.log(N) / Math.log(2);
    }

    //某节点index为n,left child为2n+1, right child为2n+2
    private static TreeNode buildChildren(List<Integer> list, int nodeIndex) {
        TreeNode node = null;
        if (nodeIndex < list.size() && list.get(nodeIndex) != null) {
            node = new TreeNode(list.get(nodeIndex));
            node.left = buildChildren(list, 2 * nodeIndex + 1);
            node.right = buildChildren(list, 2 * nodeIndex + 2);
        }
        return node;
    }

    public static TreeNode buildTree(List<Integer> list) {
        int depth = Double.valueOf(log2(list.size() + 1)).intValue();
        TreeNode head = buildChildren(list, 0);

        return head;
    }

    public static void DFS(TreeNode node) {
        if (node != null) {
            System.out.println(node.val);
            DFS(node.left);
            DFS(node.right);
        }
    }

    public static void BFS(TreeNode node) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode curr = node;
        stack.push(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            System.out.println(curr.val);
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
    }
}
