package com.cloud.leetcode.first.bad.version;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
    public int firstBadVersion(int n) {
        List<Integer> collect = IntStream.rangeClosed(1, 1000).boxed().collect(Collectors.toList());
        return 0;
    }
}
