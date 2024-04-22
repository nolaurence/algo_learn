package cn.nolaurence.labuladong.linkedlist;

public class LeetCode19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        // 珊瑚倒数第 n 个，要先找到倒数第 n + 1个节点
        ListNode x = findFromEnd(dummy, n + 1);
        x.next = x.next.next;
        return dummy.next;
    }

    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        return p2;
    }

    public static void main(String[] args) {
        int[] l1Array = new int[]{1, 2, 3, 4, 5};
        ListNode l1 = Utils.initLinkedList(l1Array);
        LeetCode19 instance = new LeetCode19();
        Utils.printLinkedList(instance.removeNthFromEnd(l1, 2));
    }
}
