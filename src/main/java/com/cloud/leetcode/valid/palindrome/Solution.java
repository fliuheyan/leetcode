package com.cloud.leetcode.valid.palindrome;

import com.google.common.base.Preconditions;

public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, k = s.length() - 1;
        while (i < k) {
            while (!Character.isLetter(s.charAt(i))) i++;
            while (!Character.isLetter(s.charAt(k))) k--;
            if (Character.toUpperCase(s.charAt(i))
                    != Character.toUpperCase(s.charAt(k))) return false;
            i++;
            k--;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        boolean result1 = solution.isPalindrome("A man, a plan, a canal: Panama");

        Preconditions.checkArgument(result1);

        boolean result2 = solution.isPalindrome("race a car");

        Preconditions.checkArgument(!result2);
    }
}
