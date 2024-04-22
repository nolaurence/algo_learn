package cn.nolaurence.labuladong.linkedlist;

public class Utils {

    public static ListNode initLinkedList(int[] array) {
        // 初始化第一个节点
        ListNode start = new ListNode(array[array.length - 1]);
        for (int i = 1; i < array.length; i++) {
            int index = array.length - i - 1;

            // 实例化一个临时节点
            ListNode tempNode = new ListNode(array[index]);

            // 连接上
            tempNode.next = start;
            start = tempNode;
        }
        return start;
    }

    public static void printLinkedList(ListNode head) {
        System.out.print("[");
        while(head != null) {
            if (head.next == null) {
                System.out.format("%d]", head.val);
            } else {
                System.out.format("%d, ", head.val);
            }
            head = head.next;
        }
    }
}
