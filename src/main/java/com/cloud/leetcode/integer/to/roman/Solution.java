package com.cloud.leetcode.integer.to.roman;

import com.google.common.base.Preconditions;

import java.util.HashMap;
import java.util.Map;

//800 DCCC
public class Solution {
    private Map<Integer, String> map = new HashMap<>();

    public Solution() {
        map.put(1, "I");
        map.put(5, "V");
        map.put(10, "X");
        map.put(50, "L");
        map.put(100, "C");
        map.put(500, "D");
        map.put(1000, "M");
    }

    //TODO
    public String intToRoman(int num) {
        int[] ints = splitByBite(num);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int anInt : ints) {
            sb.append(convertToRoma(anInt));
        }
        return sb.toString();
    }

    private int getDecimals(int num) {
        return String.valueOf(num).length() - 1;
    }

    private int getBaseNum(int decimals) {
        int basic = 0;
        if (decimals == 0) {
            basic = 1;
        } else if (decimals == 1) {
            basic = 10;
        } else if (decimals == 2) {
            basic = 100;
        } else if (decimals == 3) {
            basic = 1000;
        }
        return basic;
    }

    private String convertToRoma(int num) {
        // 1-3 1*3
        // 4   1 5
        // 6-8 5111
        //9   1 10
        StringBuilder sb = new StringBuilder();
        if (map.containsKey(num)) {
            return map.get(num);
        } else {
            int decimals = getDecimals(num);
            int baseNum = getBaseNum(decimals);
            int mod = num % baseNum;
            if (1 < mod && mod < 4) {
                for (int i = 0; i < mod; i++) {
                    sb.append(map.get(baseNum));
                }
            } else if (mod == 4) {
                sb.append(map.get(baseNum));
                sb.append(map.get(5 * baseNum));
            } else if (mod > 5 && mod < 9) {
                sb.append(5 * baseNum);
                for (int i = 0; i < mod; i++) {
                    sb.append(map.get(baseNum));
                }
            } else if (mod == 9) {
                sb.append(map.get(baseNum));
                sb.append(map.get(baseNum * 10));
            }
        }
        return sb.toString();
    }

    private int[] splitByBite(int num) {
        String str = String.valueOf(num);
        char[] chars = str.toCharArray();
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = i * 10 ^ (chars.length - 1 - i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String roman1994 = solution.intToRoman(1994);
        System.out.println(roman1994);
        Preconditions.checkArgument(roman1994.equals("MCMXCIV"));

        String roman58 = solution.intToRoman(58);
        Preconditions.checkArgument(roman58.equals("LVIII"));

        String roman3 = solution.intToRoman(3);
        Preconditions.checkArgument(roman3.equals("III"));

        String roman4 = solution.intToRoman(4);
        Preconditions.checkArgument(roman4.equals("IV"));

        String roman9 = solution.intToRoman(9);
        Preconditions.checkArgument(roman9.equals("IX"));
    }
}
