package main.java.com.cloud.leetcode.string.to.integer;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    public int myAtoi(String str) {
        char[] chars = str.toCharArray();
        boolean encounterNum = false;
        int j = 0;
        char[] result = new char[chars.length];
        for (int index = 0; index < chars.length; index++) {
            char currentChar = chars[index];
            if (!encounterNum) {
                if (Character.isWhitespace(currentChar)) {
                } else if (Character.isDigit(currentChar)) {
                    encounterNum = true;
                    result[j] = currentChar;
                    j++;
                } else if (currentChar == '-' || currentChar == '+') {
                    result[0] = currentChar;
                    j++;
                } else if (Character.isLetter(chars[index])) {
                    result[0] = '0';
                    break;
                }
            } else if (Character.isDigit(currentChar)) {
                result[j] = currentChar;
                j++;
            }
        }
        return charArrayToInt(result);
    }

    private int charArrayToInt(char[] chars) {
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            if (Character.isDigit(c) || (c == '+') || (c == '-')) {
                sb.append(c);
            } else {
                break;
            }
        }
        BigDecimal bigDecimal = new BigDecimal(sb.toString());
        boolean lessThanMix = bigDecimal.compareTo(new BigDecimal(Integer.MIN_VALUE)) == -1;
        boolean greaterThanMax = bigDecimal.compareTo(new BigDecimal(Integer.MAX_VALUE)) == 1;
        if (lessThanMix) return Integer.MIN_VALUE;
        if (greaterThanMax) return Integer.MAX_VALUE;
        return Integer.parseInt(sb.toString());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int int42 = solution.myAtoi("42");
        System.out.println(int42);

        int negative42 = solution.myAtoi("     -42");
        System.out.println(negative42);

        int numWithWords = solution.myAtoi("4193 with words");
        System.out.println(numWithWords);

        int wordsWithNum = solution.myAtoi("words and 987");
        System.out.println(wordsWithNum);

        int bigint = solution.myAtoi("-91283472332");
        System.out.println(bigint);
    }

}
