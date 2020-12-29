package com.cloud.leetcode.queue.build.from.two.stacks;

import com.google.common.base.Preconditions;

import java.util.Stack;

public class Solution {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> stack2 = new Stack<>();

    public Solution() {

    }

    public void appendTail(int value) {
        stack.add(value);
    }

    public int deleteHead() {
        int result;
        if (stack.isEmpty()) return -1;
        while (!stack.isEmpty()) {
            stack2.push(stack.pop());
        }
        result = stack2.pop();
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
        return result;
    }

    public String convertString() {
        StringBuilder sb = new StringBuilder();
        for (int index = 0; index < stack.size(); index++) {
            sb.append(stack.get(index));
            if (index != stack.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.appendTail(1);
        solution.appendTail(2);
        solution.appendTail(3);
        solution.appendTail(4);
        solution.appendTail(5);
        int deleteHead = solution.deleteHead();
        Preconditions.checkArgument(deleteHead == 1);
        String result = solution.convertString();
        Preconditions.checkArgument(result.equals("2,3,4,5"));
    }

}
