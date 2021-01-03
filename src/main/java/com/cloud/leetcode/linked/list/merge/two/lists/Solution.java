package com.cloud.leetcode.linked.list.merge.two.lists;

import com.cloud.leetcode.helper.ListNode;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head, current;
        if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }
        current = head;
        while (l1 != null || l2 != null) {
            while (l1 != null && (l2 == null || l1.val <= l2.val)) {
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }
            while (l2 != null && (l1 == null || l2.val < l1.val)) {
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        return head;
    }
}
