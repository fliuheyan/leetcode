package com.cloud.leetcode.reverse.string;

import com.google.common.base.Preconditions;

public class Solution {
    public String reverseString(char[] s) {
        int i = 0, k = s.length - 1;
        while (i < k) {
            char temp = s[i];
            s[i++] = s[k];
            s[k--] = temp;
        }
        return String.valueOf(s);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String result = solution.reverseString(new char[]{'h', 'e', 'l', 'l', 'o'});
        Preconditions.checkArgument(result.equals("olleh"));

        String result1 = solution.reverseString(new char[]{'H','a','n','n','a','h'});
        Preconditions.checkArgument(result1.equals("hannaH"));
    }
}
