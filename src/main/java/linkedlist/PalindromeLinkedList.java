package linkedlist;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        ListNode start = head;
        int count = 0;
        while (start != null){
            count++;
            start = start.next;
        }

        boolean even = count % 2 == 0;
        int halfway = count / 2;
        ListNode prev = head;
        ListNode next = head.next;
        int loopCount = 1;
        while (next != null){
            if(loopCount < halfway) {
                ListNode oldHead = head;
                ListNode oldNext = next;
                prev.next = oldNext.next;
                next = oldNext.next;
                head = oldNext;
                head.next = oldHead;
            } else if(!even && loopCount == halfway){
                next = next.next;
            } else if(head.val == next.val){
                head = head.next;
                next = next.next;
            } else {
                return false;
            }
            loopCount++;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode first = new ListNode(2);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(1);
        ListNode five = new ListNode(1);

        head.next = first;
        first.next = second;
//        second.next = third;
//        third.next = fourth;
        //fourth.next = five;

        // 1 2 3 3 2 1 - 6
        // 1 2 3 - second loop 1st half store
        // 3 2 1 - second loop 2nd half match
        // 1 2 3 2 1
        // 1 2 3 2 1 - 5 / 2 = 2 and skip the 3rd

        boolean palindrome = isPalindrome(head);
        System.out.println(String.format("isPalindrome %s", palindrome));

    }
}
