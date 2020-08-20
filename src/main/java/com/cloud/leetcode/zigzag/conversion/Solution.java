package com.cloud.leetcode.zigzag.conversion;

import com.google.common.base.Preconditions;

import java.util.Stack;

public class Solution {
    public String convert(String s, int numRows) {
        int basic = numRows + (numRows - 2);
        int length = s.length();
        int mod = length % basic;
        int columns = ((length - mod) / basic) * (numRows - 1) + (mod > numRows ? (mod - numRows) : 1);
        Character[][] table = new Character[columns][numRows];
        Stack<Character> stack = new Stack<>();
        for (int i = length - 1; i >= 0; i--) {
            stack.add(s.charAt(i));
        }
        for (int columnIndex = 0; columnIndex < columns; columnIndex++) {
            for (int rowIndex = 0; rowIndex < numRows; rowIndex++) {
                int mod1 = columnIndex % (numRows - 1);
                if (mod1 == 0 && !stack.isEmpty()) {
                    table[columnIndex][rowIndex] = stack.pop();
                } else if (rowIndex == (numRows - mod1 - 1) && !stack.isEmpty()) {
                    table[columnIndex][rowIndex] = stack.pop();
                }
            }
        }
        return tableToStr(table);
    }

    //a[x][y] x column y row
    private String tableToStr(Character[][] table) {
        StringBuilder sb = new StringBuilder();
        for (int rowIndex = 0; rowIndex < table[0].length; rowIndex++) {
            for (int columnIndex = 0; columnIndex < table.length; columnIndex++) {
                if (table[columnIndex][rowIndex] != null) {
                    sb.append(table[columnIndex][rowIndex]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.convert("PAYPALISHIRING", 3);
        Preconditions.checkArgument(result.equals("PAHNAPLSIIGYIR"));

        String result2 = solution.convert("PAYPALISHIRING", 4);
        Preconditions.checkArgument(result2.equals("PINALSIGYAHRPI"));
    }
}
