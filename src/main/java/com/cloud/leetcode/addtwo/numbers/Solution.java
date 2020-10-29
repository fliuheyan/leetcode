package com.cloud.leetcode.addtwo.numbers;

import java.util.List;
import java.util.function.Predicate;

public class Solution {

    public class ListNode {
        int val;
        ListNode next;

        void setNext(ListNode listNode) {
            this.next = listNode;
        }

        ListNode(int x) {
            val = x;
        }
    }

    //342 + 465 = 807
    //2->4->3
    //5->6->4
    public ListNode genListNodeChain(String strNum) {
        char[] chars = (new StringBuilder(strNum)).reverse().toString().toCharArray();
        ListNode[] listNodes = new ListNode[chars.length];
        for (int i = 0; i < chars.length; i++) {
            listNodes[i] = new ListNode(Integer.parseInt(String.valueOf(chars[i])));
        }
        return chainListNodes(listNodes);
    }

    public ListNode chainListNodes(ListNode[] listNodes) {
        for (int j = 0; j < listNodes.length; j++) {
            if (j != listNodes.length - 1) {
                listNodes[j].setNext(listNodes[j + 1]);
            }
        }
        return listNodes[0];
    }

    public int findDepth(ListNode listNode) {
        int i = 1;
        while (listNode.next != null) {
            i++;
            listNode = listNode.next;
        }
        return i;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode[] listNodes = new ListNode[Math.max(findDepth(l1), findDepth(l2))];
        for (int i = 0; i < listNodes.length; i++) {
            listNodes[i] = new ListNode(0);
            if (temp1 != null) {
                listNodes[i].val += temp1.val;
            }
            if (temp2 != null) {
                listNodes[i].val += temp2.val;
            }
            temp1 = temp1 != null ? temp1.next : null;
            temp2 = temp2 != null ? temp2.next : null;
        }
        return chainListNodes(listNodes);
    }

    public static void main(String[] args) {
        List.of(1,2,3).stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return false;
            }
        });
//        Solution solution = new Solution();
//        ListNode node1 = solution.genListNodeChain("342");
//        ListNode node2 = solution.genListNodeChain("465");
//
//        ListNode listNode = solution.addTwoNumbers(node1, node2);
//        solution.carryNode(listNode);
//        solution.displayNode(listNode);
    }

    public void carryNode(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            if (temp.val >= 10) {
                temp.next.val += 1;
                temp.val = temp.val % 10;
            }
            temp = temp.next;
        }
    }

    public void displayNode(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}
