package com.cloud.leetcode.first.unique.character.in.a.string;

import com.google.common.base.Preconditions;

public class Solution {
    public int firstUniqChar(String s) {
        int temp = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    temp = j;
                    break;
                }
            }
            if (temp == -1) return i;
            temp = -1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int index = solution.firstUniqChar("leetcode");

        Preconditions.checkArgument(index == 0);

        int result1 = solution.firstUniqChar("loveleetcode");

        Preconditions.checkArgument(result1 == 2);
    }
}
