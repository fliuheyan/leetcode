package com.cloud.leetcode.helper;

public class DisplayHelper {
    public static void displayNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println("##############");
    }

    public static void displayIntArray(int[] array) {
        for (int t : array) {
            System.out.println(t);
        }
    }

    public static <T> void displayArray(T[] array) {
        for (T t : array) {
            System.out.println(t.toString());
        }
    }
}
