package com.cloud.leetcode.zigzag.conversion;

import java.util.Collections;
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
//                System.out.printf("column %s row %s mod %s\n", columnIndex, rowIndex, mod1);
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
//                System.out.printf("column %s row %s value %s \n", columnIndex, rowIndex, table[columnIndex][rowIndex]);
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
        System.out.println(result);

        String result2 = solution.convert("PAYPALISHIRING", 4);
        System.out.println(result2);

//        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}};
//        System.out.println(array.length); //2
//        System.out.println(array[0]);
    }
}
