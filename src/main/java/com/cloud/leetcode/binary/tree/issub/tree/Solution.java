package com.cloud.leetcode.binary.tree.issub.tree;

import com.cloud.leetcode.helper.TreeNode;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) return false;

        return dfs(A, B)
                || isSubStructure(A.left, B)
                || isSubStructure(A.right, B);
    }

    //以当前节点为跟判断是否含有子树
    private boolean dfs(TreeNode origin, TreeNode target) {
        //先判断target，这样当target为null origin也为null的情况才能cover到
        if (target == null) return true;
        if (origin == null) return false;

        return origin.val == target.val
                && dfs(origin.left, target.left)
                && dfs(origin.right, target.right);
    }


}
