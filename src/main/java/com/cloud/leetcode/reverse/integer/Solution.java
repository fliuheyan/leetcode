package main.java.com.cloud.leetcode.reverse.integer;

public class Solution {
    public int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        char[] resultChars = new char[chars.length];
        int j = 0;
        if (chars[0] == '-') {
            resultChars[j] = '-';
            j++;
        }
        boolean isHead = true;
        for (int index = chars.length - 1; index >= 0; index--) {
            if (chars[index] != '0') {
                isHead = false;
                if (!isHead && chars[index] != '-') {
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
        System.out.println(reverse123);

        int reverseNegative = solution.reverse(-123);
        System.out.println(reverseNegative);

        int reverse120 = solution.reverse(120);
        System.out.println(reverse120);
    }
}
