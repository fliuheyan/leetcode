package com.cloud.leetcode.count.and.say;

import com.google.common.base.Preconditions;

public class Solution {
    public String countAndSay(int n) {
        String result = "1";
        if (n == 1) return result;
        for (int i = 0; i < n - 1; i++) {
            result = retrieveCountStr(result);
        }
        return result;
    }

    public String retrieveCountStr(String str) {
        if (str.length() == 1) return "11";
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int temp = 1;
            int j = i + 1;
            while (j < str.length() && str.charAt(i) == str.charAt(j)) {
                temp++;
                j++;
            }
            if (j == str.length()) {
                return result.append(temp).append(str.charAt(i)).toString();
            }
            result.append(temp).append(str.charAt(i));
            i = j;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result5 = solution.countAndSay(5);

        Preconditions.checkArgument(result5.equals("111221"));

        String result8 = solution.countAndSay(8);

        Preconditions.checkArgument(result8.equals("1113213211"));
    }
}
