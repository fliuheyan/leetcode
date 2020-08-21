package com.cloud.leetcode.palindrome.number;

import com.google.common.base.Preconditions;

public class Solution {
    public boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; i++, j--) {
            if(chars[i] != chars[j]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        boolean intNegative = solution.isPalindrome(-121);
        Preconditions.checkArgument(!intNegative);

        boolean int121 = solution.isPalindrome(121);
        Preconditions.checkArgument(int121);

        boolean int10 = solution.isPalindrome(10);
        Preconditions.checkArgument(!int10);
    }
}
