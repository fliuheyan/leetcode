package com.cloud.leetcode.binary.tree.buildtree;

import com.cloud.leetcode.helper.TreeNode;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Solution {
    private HashMap<Integer, Integer> map = new HashMap<>();
    private int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        for (int index = 0; index < inorder.length; index++) {
            map.put(inorder[index], index);
        }
        return buildSubTree(0, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int rootPreorderIndex, int left, int right) {
        TreeNode treeNode = new TreeNode(preorder[rootPreorderIndex]);
        if (left > right) return null;
        int rootInorderIndex = map.get(preorder[rootPreorderIndex]);
        treeNode.left = buildSubTree(rootPreorderIndex + 1, left, rootInorderIndex - 1);
        int leftLength = rootInorderIndex - left;
        treeNode.right = buildSubTree(rootPreorderIndex + 1 + leftLength, rootInorderIndex + 1, right);
        return treeNode;
    }

    private List<Integer> preOrderTraversal(TreeNode head) {
        List<Integer> result = new ArrayList<>();
        if (head == null) return result;
        result.add(head.val);
        if (head.left != null) result.addAll(preOrderTraversal(head.left));
        if (head.right != null) result.addAll(preOrderTraversal(head.right));
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        TreeNode treeNode = solution.buildTree(preorder, new int[]{9, 3, 15, 20, 7});
        List<Integer> integers = solution.preOrderTraversal(treeNode);

        Preconditions.checkArgument(integers.stream().map(Objects::toString).collect(Collectors.joining(",")).equals("3, 9, 20, 15, 7".replace(" ","")));
    }
}
