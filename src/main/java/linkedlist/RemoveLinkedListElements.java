package linkedlist;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 *
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class RemoveLinkedListElements {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode prev = head;
        ListNode next = head;

        while(next != null){
            if(next.val == val){
                if(next == head){
                    head = next.next;
                    prev = next.next;
                    next = next.next;
                } else {
                    prev.next = next.next;
                    next = next.next;
                }
            } else {
                prev = next;
                next = next.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode five = new ListNode(1);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = five;


        ListNode filtered = removeElements(head, 1);
        System.out.println(String.format("Filtered list %s", filtered));

    }
}
