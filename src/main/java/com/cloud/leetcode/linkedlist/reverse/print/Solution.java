package com.cloud.leetcode.linkedlist.reverse.print;

import com.cloud.leetcode.helper.ListNode;
import com.google.common.base.Preconditions;

import java.util.List;
import java.util.Stack;

public class Solution {
    //stack
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current.val);
            current = current.next;
        }
        int[] result = new int[stack.size()];
        for (int index = 0; index < result.length; index++) {
            result[index] = stack.pop();
        }
        return result;
    }

    //不用stack
    //扫描两变
    //第一遍取得链表长度
    //第二遍链表正序遍历，同时数组逆序赋值
    public int[] reversePrint1(ListNode head) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }
        int[] result = new int[count];
        current = head;
        for (int index = count - 1; index >= 0; index--) {
            result[index] = current.val;
            current = current.next;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = ListNode.listToLinkedList(List.of(1, 3, 2));
        int[] result = solution.reversePrint(head);

        Preconditions.checkArgument(result[0] == 2);
        Preconditions.checkArgument(result[1] == 3);
        Preconditions.checkArgument(result[2] == 1);

        int[] result1 = solution.reversePrint1(head);
        Preconditions.checkArgument(result1[0] == 2);
        Preconditions.checkArgument(result1[1] == 3);
        Preconditions.checkArgument(result1[2] == 1);
    }
}
