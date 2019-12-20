package linkedlist;

/**
 * Reverse a singly linked list.
 *
 * Example:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * Follow up:
 *
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class ReverseLinkedList {
    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode prev = head;
        ListNode next = head.next;
        while (next != null){
            ListNode oldHead = head;
            ListNode oldNext = next;
            prev.next = oldNext.next;
            next = oldNext.next;
            head = oldNext;
            head.next = oldHead;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode five = new ListNode(5);

        // 1->2->3->4->5->NUL
        // 2->1->3->4->5->NUL
        // 3->2->1->4->5->NUL
        // 4->3->2->1->5->NUL
        // 5->4->3->2->1->NUL

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = five;

        ListNode reversed = reverseList(head);
        System.out.println(String.format("Node value at index %s = %s", 0, reversed.val));
        System.out.println(String.format("Node value at index %s = %s", 1, reversed.next.val));
        System.out.println(String.format("Node value at index %s = %s", 2, reversed.next.next.val));
        System.out.println(String.format("Node value at index %s = %s", 3, reversed.next.next.next.val));
        System.out.println(String.format("Node value at index %s = %s", 4, reversed.next.next.next.next.val));
        System.out.println(String.format("Node value at index %s = %s", 5, reversed.next.next.next.next.next.val));
    }
}
