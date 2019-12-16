package linkedlist;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }

    public static boolean hasCycleHash(ListNode head) {
        if(head == null){
            return false;
        }
        Set<ListNode> nodes =  new HashSet<>();
        while(head.next != null){
            if(nodes.contains(head)){
                return true;
            }
            nodes.add(head);
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return false;
        }
        ListNode twoAhead = head.next;
        while(head.next != null && twoAhead != null){
            if(head == twoAhead){
                return true;
            }
            if(twoAhead.next == null || twoAhead.next.next == null){
                twoAhead = null;
            } else {
                twoAhead = twoAhead.next.next;
            }
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args){
        ListNode head = new ListNode(0);

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        head.next = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = head;

        System.out.println(String.format("Has a cycle: %s", hasCycle(head)));
    }
}
