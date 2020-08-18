package com.cloud.leetcode.zigzag.conversion;

import java.util.Collections;
import java.util.Stack;

public class Solution {
    public String convert(String s, int numRows) {
        int basic = numRows + (numRows - 2);
        int length = s.length();
        int mod = length % basic;
        int columns = (length - mod) / basic + (mod > numRows ? (mod - numRows) : 1);
        int[][] table = new int[columns][numRows];
        Stack<char[]> stack = new Stack<>();
        stack.addAll(Collections.singletonList((new StringBuilder(s)).reverse().toString().toCharArray()));
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < numRows; j++) {
                if (i % (numRows - 1) == 0) {
                    
                }
            }
        }

    }
}
