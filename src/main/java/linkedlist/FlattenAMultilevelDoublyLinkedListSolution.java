package linkedlist;

/**
 * You are given a doubly linked list which in addition to the next and previous pointers, it could have a child pointer, which may or may not point to a separate doubly linked list. These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, as shown in the example below.
 *
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. You are given the head of the first level of the list.
 *
 *
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 * Explanation:
 *
 * The multilevel linked list in the input is as follows:
 *
 *
 *
 * After flattening the multilevel linked list it becomes:
 *
 *
 * Example 2:
 *
 * Input: head = [1,2,null,3]
 * Output: [1,3,2]
 * Explanation:
 *
 * The input multilevel linked list is as follows:
 *
 *   1---2---NULL
 *   |
 *   3---NULL
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 *
 * How multilevel linked list is represented in test case:
 *
 * We use the multilevel linked list from Example 1 above:
 *
 *  1---2---3---4---5---6--NULL
 *          |
 *          7---8---9---10--NULL
 *              |
 *              11--12--NULL
 * The serialization of each level is as follows:
 *
 * [1,2,3,4,5,6,null]
 * [7,8,9,10,null]
 * [11,12,null]
 * To serialize all levels together we will add nulls in each level to signify no node connects to the upper node of the previous level. The serialization becomes:
 *
 * [1,2,3,4,5,6,null]
 * [null,null,7,8,9,10,null]
 * [null,11,12,null]
 * Merging the serialization of each level and removing trailing nulls we obtain:
 *
 * [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 *
 *
 * Constraints:
 *
 * Number of Nodes will not exceed 1000.
 * 1 <= Node.val <= 10^5
 */
public class FlattenAMultilevelDoublyLinkedListSolution {

    static class Node {
        public Integer val;
        public Node prev;
        public Node next;
        public Node child;
    };

    public static Node flatten(Node head) {
        Node flattened = head;
        while (flattened != null){
            if(flattened.child != null) {
                Node oldNext = flattened.next;
                Node child = flatten(flattened.child);
                flattened.child = null;
                child.prev = flattened;
                flattened.next = child;
                flattened = child;

                Node last = null;
                while(child != null){
                    last = child;
                    child = child.next;
                }
                last.next = oldNext;
                if(oldNext != null){
                    oldNext.prev = last;
                }
            } else {
                flattened = flattened.next;
            }
        }
        return head;
    }

    public static void main(String[] args){
        // [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
        // [1,2,3,7,8,11,12,9,10,4,5,6]
        Node first = new Node();
        Node second = new Node();
        Node third = new Node();
        Node fourth = new Node();
        Node fifth = new Node();
        Node sixth = new Node();
        Node seventh = new Node();
        Node eighth = new Node();
        Node ninth = new Node();
        Node tenth = new Node();
        Node eleventh = new Node();
        Node twelveth = new Node();

        first.val = 1;
        first.next = second;

        second.val = 2;
        second.next = third;
        second.prev = first;

        third.val = 3;
        third.next = fourth;
        third.prev = second;
        third.child = seventh;

        fourth.val = 4;
        fourth.next = fifth;
        fourth.prev = third;

        fifth.val = 5;
        fifth.next = sixth;
        fifth.prev = fourth;

        sixth.val = 6;
        sixth.prev = fifth;

        // connected with three;
        seventh.val = 7;
        seventh.next = eighth;

        eighth.val = 8;
        eighth.next = ninth;
        eighth.prev = seventh;
        eighth.child = eleventh;

        ninth.val = 9;
        ninth.next = tenth;
        ninth.prev = eighth;

        tenth.val = 10;
        tenth.prev = ninth;

        // connected with 8
        eleventh.val = 11;
        eleventh.next = twelveth;

        twelveth.val = 12;
        twelveth.prev = eleventh;

        Node flattened = flatten(first);
        System.out.println("Finished");
    }

}


