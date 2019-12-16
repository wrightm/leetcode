package linkedlist;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class RemoveNthNodeFromEndOfList {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode start = head;
        while(start != null){
            length++;
            start = start.next;
        }
        int removeIndex = length - n;
        int currentNodeIndex = 0;
        start = head;
        ListNode prev = head;
        while(start != null){
            if(currentNodeIndex == removeIndex){
                if(prev == start){
                    head = head.next;
                    return head;
                } else {
                    prev.next = start.next;
                    return head;
                }
            }
            prev = start;
            start = start.next;
            currentNodeIndex++;
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


        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = five;

        int nLast = 2;
        ListNode filteredList = removeNthFromEnd(head, nLast);
        System.out.println(String.format("Last %s node has been removed from the linked list %s", nLast, filteredList));
    }
}
