package com.cloud.leetcode.linked.list.find.kth.from.end;

import com.cloud.leetcode.helper.ListNode;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        int max = 0;
        ListNode current = head;
        while (current != null) {
            max++;
            current = current.next;
        }
        int step = max - k;
        current = head;
        while (step > 0) {
            step--;
            current = current.next;
        }
        return current;
    }
}
