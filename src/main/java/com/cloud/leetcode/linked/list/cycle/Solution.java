package com.cloud.leetcode.linked.list.cycle;

import com.cloud.leetcode.helper.ListNode;
import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public boolean hasCycle(ListNode head) {
        List<ListNode> list = new ArrayList();
        ListNode curr = head;
        while (curr != null) {
            if (list.contains(curr)) {
                return true;
            } else {
                list.add(curr);
            }
            curr = curr.next;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode head = ListNode.constructNodes(List.of(3, 2, 0, -4));
        List<ListNode> listNodes = ListNode.headToList(head);
        listNodes.get(listNodes.size() - 1).next = listNodes.get(1);
        Preconditions.checkArgument(solution.hasCycle(head));

        ListNode head1 = ListNode.constructNodes(List.of(1,2));
        List<ListNode> listNodes1 = ListNode.headToList(head1);
        listNodes1.get(listNodes1.size() - 1).next = listNodes1.get(0);
        Preconditions.checkArgument(solution.hasCycle(head1));

        ListNode head2 = ListNode.constructNodes(List.of(1));
        Preconditions.checkArgument(!solution.hasCycle(head2));
    }
}
