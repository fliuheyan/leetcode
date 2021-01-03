package com.cloud.leetcode.linked.list.reverse;

import com.cloud.leetcode.helper.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
