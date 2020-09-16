package com.cloud.leetcode.plus.one;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {
    public int[] plusOne(int[] digits) {
        String numberStr = Arrays.stream(digits).boxed().map(Object::toString).collect(Collectors.joining(""));
        int integer = Integer.parseInt(numberStr);
        char[] chars = String.valueOf(integer + 1).toCharArray();
        int[] result = new int[chars.length];
        int k = 0;
        for (char cchar : chars) {
            result[k++] = Character.getNumericValue(cchar);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result1 = solution.plusOne(new int[]{1, 2, 3});
        Preconditions.checkArgument(result1[0] == 1);
        Preconditions.checkArgument(result1[1] == 2);
        Preconditions.checkArgument(result1[2] == 4);

        int[] result2 = solution.plusOne(new int[]{4, 3, 2, 1});
        Preconditions.checkArgument(result2[0] == 4);
        Preconditions.checkArgument(result2[1] == 3);
        Preconditions.checkArgument(result2[2] == 2);
        Preconditions.checkArgument(result2[3] == 2);
    }
}
