package com.cloud.leetcode.valid.parentheses;

import com.google.common.base.Preconditions;

import java.util.HashMap;

public class Solution {
    public boolean isValid(String s) {
        HashMap<String, String> map = new HashMap();
        map.put("{", "}");
        map.put("(", ")");
        map.put("[", "]");
        if (s.length() % 2 != 0) return false;
        for (int i = 0; i < s.length() / 2 - 1; i++) {
            if (!(map.get(String.valueOf(s.charAt(i))).equals(String.valueOf(s.charAt(i + 1)))
                    || map.get(String.valueOf(s.charAt(i))).equals(String.valueOf(s.charAt(s.length() - 1 - i)))))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.isValid("()"));
//        System.out.println(solution.isValid("{[]}"));
        System.out.println(solution.isValid("()[]{}"));
//        Preconditions.checkArgument(solution.isValid("()"));
//        Preconditions.checkArgument(solution.isValid("()[]{}"));
//        Preconditions.checkArgument(solution.isValid("(]"));
//        Preconditions.checkArgument(solution.isValid("([)]"));
//        Preconditions.checkArgument(solution.isValid("{[]}"));
    }
}
