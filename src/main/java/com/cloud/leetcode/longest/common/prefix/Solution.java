package com.cloud.leetcode.longest.common.prefix;

import com.google.common.base.Preconditions;

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        String preStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            preStr = findCommonPrefix(preStr, strs[i]);
            if (preStr.isEmpty()) return "";
        }
        return preStr;
    }

    private String findCommonPrefix(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Math.min(str1.length(), str2.length()); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                sb.append(str1.charAt(i));
            } else {
                break;
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result1 = solution.longestCommonPrefix(new String[]{"flower", "flow", "flight"});
        Preconditions.checkArgument(result1.equals("fl"));

        String result2 = solution.longestCommonPrefix(new String[]{"dog", "racecar", "car"});
        Preconditions.checkArgument(result2.equals(""));
    }
}
