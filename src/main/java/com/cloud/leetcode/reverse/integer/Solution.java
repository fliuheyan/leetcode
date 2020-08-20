package com.cloud.leetcode.reverse.integer;

import com.google.common.base.Preconditions;

public class Solution {
    public int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        char[] resultChars = new char[chars.length];
        int j = 0;
        if (chars[0] == '-') {
            resultChars[j] = '-';
            j++;
        }
        for (int index = chars.length - 1; index >= 0; index--) {
            if (chars[index] != '0') {
                if (chars[index] != '-') {
                    resultChars[j] = chars[index];
                    j++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char resultChar : resultChars) {
            if (resultChar != Character.MIN_VALUE) {
                sb.append(resultChar);
            }
        }
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int reverse123 = solution.reverse(123);
        Preconditions.checkArgument(reverse123 == 321);

        int reverseNegative = solution.reverse(-123);
        Preconditions.checkArgument(reverseNegative == -321);

        int reverse120 = solution.reverse(120);
        Preconditions.checkArgument(reverse120 == 21);
    }
}
