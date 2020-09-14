package com.cloud.leetcode.merge.two.sorted.lists;
import com.cloud.leetcode.helper.DisplayHelper;
import com.cloud.leetcode.helper.ListNode;

public class Solution {


    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode curr;
        if (l1.val < l2.val) {
            head = l1;
            curr = l1;
            l1 = l1.next;
        } else {
            head = l2;
            curr = l2;
            l2 = l2.next;
        }
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
                curr = curr.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
                curr = curr.next;
            }
        }
        if (l1 == null) {
            curr.next = l2;
        }
        if( l2 == null ) {
            curr.next = l1;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode4 = new ListNode(4);
        listNode1.next = listNode2;
        listNode2.next = listNode4;

        ListNode listNode11 = new ListNode(1);
        ListNode listNode33 = new ListNode(3);
        ListNode listNode44 = new ListNode(4);
        listNode11.next = listNode33;
        listNode33.next = listNode44;

        Solution solution = new Solution();
        ListNode listNode = solution.mergeTwoLists(listNode1, listNode11);

        DisplayHelper.displayNode(listNode);
    }
}
