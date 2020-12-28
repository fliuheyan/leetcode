package com.cloud.leetcode.string.replace.space;

import com.google.common.base.Preconditions;

public class Solution {
    public String replaceSpace(String s) {
        return s.replace(" ", "%20");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "We are happy.";
        String result = solution.replaceSpace(input);

        Preconditions.checkArgument(result.equals("We%20are%20happy."));
    }
}
