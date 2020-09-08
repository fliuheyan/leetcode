package com.cloud.leetcode.helper;

public class DisplayHelper {
    public static void displayNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }
}
