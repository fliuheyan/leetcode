package com.cloud.leetcode.linked.list.first.common.node;

import com.cloud.leetcode.helper.ListNode;
import com.google.common.base.Preconditions;

import java.util.List;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode listNode1 = headA;
        ListNode listNode2 = headB;
        while (listNode1 != listNode2) {
            listNode1 = listNode1 == null ? headB : listNode1.next;
            listNode2 = listNode2 == null ? headA : listNode2.next;
        }
        return listNode1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNodeA = ListNode.listToLinkedList(List.of(4, 1));
        ListNode listNodeB = ListNode.listToLinkedList(List.of(5, 6, 1));
        ListNode listNodeCommon = ListNode.listToLinkedList(List.of(8, 4, 5));
        listNodeA.next = listNodeCommon;
        listNodeB.next = listNodeCommon;
        ListNode intersectionNode = solution.getIntersectionNode(listNodeA, listNodeB);
        Preconditions.checkArgument(intersectionNode.val == 8);


        ListNode listNodeC = ListNode.listToLinkedList(List.of(4, 1));
        ListNode listNodeD = ListNode.listToLinkedList(List.of(5, 6, 1));
        Preconditions.checkArgument(solution.getIntersectionNode(listNodeC, listNodeD) == null);
    }
}
