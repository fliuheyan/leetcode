package com.cloud.leetcode.delete.a.node.in.a.linked.list;

import com.cloud.leetcode.helper.DisplayHelper;
import com.cloud.leetcode.helper.ListNode;

import java.util.List;

public class Solution {
    public ListNode deleteNode(ListNode node, int value) {
        ListNode curr = node;
        ListNode head = node;
        ListNode prev = node;
        while (curr.next != null) {
            if (curr.val == value) {
                if (curr == prev) {
                    head = curr.next;
                    break;
                }
                prev.next = curr.next;
                break;
            } else {
                prev = curr;
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head1 = ListNode.listToLinkedList(List.of(4, 5, 1, 9));
        DisplayHelper.displayNode(solution.deleteNode(head1, 5));

        ListNode head2 = ListNode.listToLinkedList(List.of(4, 5, 1, 9));
        DisplayHelper.displayNode(solution.deleteNode(head2, 1));

        ListNode head3 = ListNode.listToLinkedList(List.of(1, 2, 3, 4));
        DisplayHelper.displayNode(solution.deleteNode(head3, 3));

        ListNode head4 = ListNode.listToLinkedList(List.of(0, 1));
        DisplayHelper.displayNode(solution.deleteNode(head4, 0));

        ListNode head5 = ListNode.listToLinkedList(List.of(-3, 5, -99));
        DisplayHelper.displayNode(solution.deleteNode(head5, -3));
    }
}
