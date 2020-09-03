package com.cloud.leetcode.remove.nth.node.from.end.of.list;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current = head;
        int length = getLength(head);
        int temp = 1;
        while (current != null) {
            if (temp == length - n) {
                if (current.next.next == null) {
                    current.next = null;
                } else {
                    current.next = current.next.next;
                }
            }
            current = current.next;
            temp++;
        }
        return head;
    }

    private ListNode buildList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        return listNode1;
    }

    private int getLength(ListNode listNode) {
        int length = 0;
        if (listNode != null) {
            length++;
            while (listNode != null) {
                if(listNode.next != null) length++;
                listNode = listNode.next;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode = solution.buildList();

        ListNode result = solution.removeNthFromEnd(listNode, 2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

}
