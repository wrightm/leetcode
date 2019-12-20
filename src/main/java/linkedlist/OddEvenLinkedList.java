package linkedlist;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * Note:
 *
 * The relative order inside both the even and odd groups should remain as it was in the input.
 * The first node is considered odd, the second node even and so on ...
 */
public class OddEvenLinkedList {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode prevOdd = head;
        ListNode prev = head;
        ListNode next = head.next;

        int count = 2;
        while (next != null){
            if(count % 2 != 0){
                ListNode oldNext = next;
                ListNode oldPrevOddNext = prevOdd.next;
                prev.next = oldNext.next;
                next = oldNext.next;
                prevOdd.next = oldNext;
                oldNext.next = oldPrevOddNext;
                prevOdd = oldNext;

            } else {
                prev = next;
                next = next.next;
            }
            count++;
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


//        head.next = first;
//        first.next = second;
//        second.next = third;
//        third.next = fourth;
//        fourth.next = five;

        int nLast = 2;
        ListNode filteredList = oddEvenList(head);
        System.out.println(String.format("Last %s node has been removed from the linked list %s", nLast, filteredList));
    }
}
