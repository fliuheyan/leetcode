package com.cloud.leetcode.roma.to.integer;

import java.util.HashMap;
import java.util.Map;

public class Solution {
//    private Map<String, Integer> map = new HashMap<>();
//
//    public Solution() {
//        map.put("I", 1);
//        map.put("V", 5);
//        map.put("X", 10);
//        map.put("L", 50);
//        map.put("C", 100);
//        map.put("D", 500);
//        map.put("M", 1000);
//    }

//
//    private int getDecimals(int num) {
//        return String.valueOf(num).length() - 1;
//    }
//
//    private int getBaseNum(int decimals) {
//        return (int) Math.pow(10, decimals);
//    }
//
//    public int romanToInt(String s) {
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//
//        }
//    }


        //简单做法
    //1. 把数组中的罗马数字全部转换为阿拉伯数字
    //2. 对于每位来讲(个位，十位，百位)，只会发生一次加减的情况即IV,VII,IX只会出现一次
    //3. 所以逻辑就可以简化为，用后一位与前一位做比较，如果后一位大于前一位，
        // 则应该减去前一位的值(不存在V,X同时存在的情况)，否则加就行了
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for(int i = 1;i < s.length(); i ++) {
            int num = getValue(s.charAt(i));
            System.out.println("####### preNum " + preNum);
            System.out.println("####### num " + num);
            if(preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;
        return sum;
    }

    private int getValue(char ch) {
        switch(ch) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int xxiv = solution.romanToInt("XXVIII");
        System.out.println(xxiv);
    }
}
