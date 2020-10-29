package com.cloud.leetcode.odd.even.linked.list;

import com.cloud.leetcode.helper.ListNode;

import java.util.List;

public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode oddHead = null;
        ListNode oddCurrent = null;
        ListNode evenHead = null;
        ListNode evenCurrent = null;
        ListNode current;
        if (isOdd(head)) {
            oddHead = head;
            oddCurrent = head;
        } else {
            evenHead = head;
            evenCurrent = head;
        }
        current = head.next;
        while (current != null) {
            if (isOdd(current)) {
                if (oddHead == null) {
                    oddHead = current;
                } else {
                    oddCurrent.next = current;
                }
                oddCurrent = current;
            } else {
                if (evenCurrent == null) {
                    evenHead = current;
                } else {
                    evenCurrent.next = current;
                }
                evenCurrent = current;
            }
            current = current.next;
        }
        if (oddHead == null) {
            return evenHead;
        } else {
            if (evenHead != null) {
                oddCurrent.next = evenHead;
            }
        }
        return oddHead;
    }

    boolean isOdd(ListNode node) {
        return node.val % 2 != 0;
    }

    public static void main(String[] args) {

    }
}
