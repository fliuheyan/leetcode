package com.cloud.leetcode.integer.to.roman.generate.parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private String appendAtLast(String str, int i) {

    }

    //left right 代表剩余数量
    //左边要小于右边，因为要先有左边括号，才能有右边
    public List<String> dfs(String str, int left, int right, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(str);
            return result;
        }
        if (left > right) return result;
        if (left > 0) {
            dfs(str + "(", left - 1, right, result);
        }
        if (right > 0) {
            dfs(str + ")", left, right-1,result);
        }
        return result;
    }
}
