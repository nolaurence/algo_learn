package cn.nolaurence.labuladong.linkedlist;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

public class LeetCode23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        for (ListNode head: lists) {
            if (head != null) {
                pq.add(head);
            }
        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }

            p = p.next;
        }
        return dummy.next;
    }

    @Test
    public void test() {
        int[][] listsArray = new int[][]{
                new int[]{1, 4, 5},
                new int[]{1, 3, 4},
                new int[]{2, 6},
        };
        ListNode[] lists = new ListNode[listsArray.length];
        int count = 0;
        for (int[] listArray : listsArray) {
            lists[count++] = Utils.initLinkedList(listArray);
        }

        Utils.printLinkedList(mergeKLists(lists));
    }
}
