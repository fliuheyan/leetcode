package com.cloud.leetcode.addtwo.numbers;

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
        char[] chars = strNum.toCharArray();
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

    //potential bug, the header need to carry. eg: 200 + 800 -> 1000
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

    //注意给出的数字是通过链表逆序存储的
    //342 + 465 = 807
    //789 + 32  = 0101
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode currentPrev = new ListNode(0); //当前节点的prev
        ListNode headPrev = currentPrev;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int temp1 = (l1 == null ? 0 : l1.val);
            int temp2 = (l2 == null) ? 0 : l2.val;
            int sum = temp1 + temp2 + carry;
            carry = sum / 10;
            sum = sum % 10;
            currentPrev.next = new ListNode(sum);
            currentPrev = currentPrev.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        //再处理一遍进位
        if (carry != 0) {
            currentPrev.next = new ListNode(carry);
        }
        return headPrev.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        ListNode node1 = solution.genListNodeChain("342");
//        ListNode node2 = solution.genListNodeChain("465");
//
//        ListNode listNode = solution.addTwoNumbers(node1, node2);
//        solution.carryNode(listNode);
//        solution.displayNode(listNode);

//        ListNode listNode3 = solution.genListNodeChain("200");
//        ListNode listNode4 = solution.genListNodeChain("800");
//        ListNode listNode1 = solution.addTwoNumbers(listNode3, listNode4);
//        solution.carryNode(listNode1);
//        solution.displayNode(listNode1);

        ListNode node1 = solution.genListNodeChain("789");
        ListNode node2 = solution.genListNodeChain("32");
        ListNode result = solution.addTwoNumbers2(node1, node2);
        solution.displayNode(result);
//        solution.displayNode(node2);
//        solution.displayNode(node2);
    }

    public void carryNode(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null && temp.next != null) {
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
