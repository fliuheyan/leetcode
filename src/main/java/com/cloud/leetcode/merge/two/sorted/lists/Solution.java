package com.cloud.leetcode.merge.two.sorted.lists;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    private ListNode generateListNode(List<Integer> list) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode head = new ListNode(list.get(0));
        for (int i = 1; i < list.size(); i++) {
            ListNode listNode = new ListNode(list.get(i));
            nodes.add(listNode);
            if (i == 1) {
                head.next = listNode;
            } else {
                nodes.get(i - 1).next = listNode;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode1 = solution.generateListNode(List.of(1, 2, 4));
        ListNode listNode2 = solution.generateListNode(List.of(1, 3, 4));
        ListNode curr;
        while (listNode1.next != null || listNode2.next != null) {
            if (listNode1.val < listNode2.val) {
                curr = listNode1;
                listNode1 = listNode1.next;
            } else {
                curr = listNode2;
            }
            while (listNode1.val < listNode2.val) {
                curr.next = listNode1;
                curr = listNode1;
            }
            if(listNode1 == null) {
                
            }
        }


    }
}
