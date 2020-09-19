package com.cloud.leetcode.helper;

import java.util.List;
import java.util.stream.Collectors;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode constructNodes(List<Integer> list) {
        List<ListNode> nodes = list.stream().map(ListNode::new).collect(Collectors.toList());
        for (int i = 0; i < nodes.size(); i++) {
            if (i != nodes.size() - 1) {
                nodes.get(i).next = nodes.get(i + 1);
            } else {
                nodes.get(i).next = null;
            }
        }
        return nodes.get(0);
    }
}
