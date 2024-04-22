package cn.nolaurence.labuladong.linkedlist;

import org.junit.jupiter.api.Test;

public class LeetCode2 {

    /**
     * 给你一个 非空 的链表，表示两个非负的整数。他们每位数字都是按照逆序的方式存储的，并且每个节点只能
     * 存储一位数字
     * 请你将两个数相加，并以相同形式返回一个表示和的链表，你可以假设除了数字0之外，这两个数都不会以0开头
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1, p2 = l2;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        int carry = 0;
        while (p1 != null || p2 != null || carry > 0) {
            int val = carry;
            if (p1 != null) {
                val += p1.val;
                p1 = p1.next;
            }

            if (p2 != null) {
                val += p2.val;
                p2 = p2.next;
            }

            // 处理进位情况
            carry = val / 10;
            val = val % 10;

            p.next = new ListNode(val);
            p = p.next;
        }

        return  dummy.next;
    }

    @Test
    public void test() {
        int[] l1Array = new int[]{2, 4, 3};
        int[] l2Array = new int[]{5, 6, 4};

        ListNode l1 = Utils.initLinkedList(l1Array);
        ListNode l2 = Utils.initLinkedList(l2Array);
    }



}


