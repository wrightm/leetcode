package linkedlist;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class AddTwoNumbers {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode addition = null;
        ListNode head = null;
        int carry = 0;
        while(l1 != null || l2 != null){
            if(l1 != null && l2 != null){
                int total = l1.val + l2.val + carry;
                if(total < 10){
                    if(addition == null){
                        addition = new ListNode(total);
                        head = addition;
                    } else {
                        addition.next = new ListNode(total);
                        addition = addition.next;
                    }
                    carry = 0;
                } else {
                    String strInt = String.valueOf(total);
                    if(addition == null){
                        addition = new ListNode(Integer.parseInt(strInt.substring(1, 2)));
                        head = addition;
                    } else {
                        addition.next = new ListNode(Integer.parseInt(strInt.substring(1, 2)));
                        addition = addition.next;
                    }
                    carry = Integer.parseInt(strInt.substring(0, 1));
                }
                l1 = l1.next;
                l2 = l2.next;
            } else if(l1 != null){
                int total = l1.val + carry;
                if(total < 10) {
                    if (addition == null) {
                        addition = new ListNode(total);
                        head = addition;
                    } else {
                        addition.next = new ListNode(total);
                        addition = addition.next;
                    }
                    carry = 0;
                } else {
                    String strInt = String.valueOf(total);
                    if(addition == null){
                        addition = new ListNode(Integer.parseInt(strInt.substring(1, 2)));
                        head = addition;
                    } else {
                        addition.next = new ListNode(Integer.parseInt(strInt.substring(1, 2)));
                        addition = addition.next;
                    }
                    carry = Integer.parseInt(strInt.substring(0, 1));
                }
                l1 = l1.next;
            } else {
                int total = l2.val + carry;
                if(total < 10) {
                    if (addition == null) {
                        addition = new ListNode(total);
                        head = addition;
                    } else {
                        addition.next = new ListNode(total);
                        addition = addition.next;
                    }
                    carry = 0;
                } else {
                    String strInt = String.valueOf(total);
                    if(addition == null){
                        addition = new ListNode(Integer.parseInt(strInt.substring(1, 2)));
                        head = addition;
                    } else {
                        addition.next = new ListNode(Integer.parseInt(strInt.substring(1, 2)));
                        addition = addition.next;
                    }
                    carry = Integer.parseInt(strInt.substring(0, 1));
                }
                l2 = l2.next;
            }
        }
        if(carry > 0){
            addition.next = new ListNode(carry);
            addition = addition.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        ListNode l1_first = new ListNode(9);
        ListNode l1_second = new ListNode(2);
        ListNode l1_third = new ListNode(3);
        ListNode l1_fourth = new ListNode(9);
        ListNode l1_five = new ListNode(9);

        l1.next = l1_first;
        l1_first.next = l1_second;
        l1_second.next = l1_third;
//        l1_third.next = l1_fourth;
//        l1_fourth.next = l1_five;

        ListNode l2 = new ListNode(9);
        ListNode l2_first = new ListNode(6);
        ListNode l2_second = new ListNode(2);
        ListNode l2_third = new ListNode(9);
        ListNode l2_fourth = new ListNode(4);
        ListNode l2_five = new ListNode(5);

        l2.next = l2_first;
        l2_first.next = l2_second;
        l2_second.next = l2_third;
        l2_third.next = l2_fourth;
        l2_fourth.next = l2_five;

        ListNode reversed = addTwoNumbers(l1, l2);
        System.out.println(String.format("Node value at index %s = %s", 0, reversed.val));
    }
}
