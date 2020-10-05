package com.cloud.leetcode.group.anagrams;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<List<String>> result1 = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        Preconditions.checkArgument(result1.size() == 3);
        for (List<String> list : result1) {
            for(String str:list) {
                System.out.println(str);
            }
            System.out.println("##############");
        }
//        Preconditions.checkArgument(result1.get(0).get(0).equals("bat"));
//        Preconditions.checkArgument(result1.get(1).get(0).equals("nat"));
//        Preconditions.checkArgument(result1.get(1).get(1).equals("tan"));
//        Preconditions.checkArgument(result1.get(2).get(0).equals("ate"));
//        Preconditions.checkArgument(result1.get(2).get(1).equals("eat"));
//        Preconditions.checkArgument(result1.get(2).get(2).equals("tea"));

        List<List<String>> result2 = solution.groupAnagrams(new String[]{""});
        Preconditions.checkArgument(result2.size() == 1);
        Preconditions.checkArgument(result2.get(0).get(0).equals(""));

        List<List<String>> result3 = solution.groupAnagrams(new String[]{"a"});
        Preconditions.checkArgument(result3.size() == 1);
        Preconditions.checkArgument(result3.get(0).get(0).equals("a"));
    }
}
