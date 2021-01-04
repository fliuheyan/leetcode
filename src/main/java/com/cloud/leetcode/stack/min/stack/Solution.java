package com.cloud.leetcode.stack.min.stack;

import java.util.Stack;

public class Solution {
    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> tempStack = new Stack<>();

    public Solution() {

    }

    public void push(int x) {
        if (tempStack.isEmpty() || x <= tempStack.peek()) tempStack.push(x);
        stack.push(x);
    }

    public void pop() {
        Integer value = stack.pop();
        if (value.equals(tempStack.peek())) tempStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return tempStack.peek();
    }
}
