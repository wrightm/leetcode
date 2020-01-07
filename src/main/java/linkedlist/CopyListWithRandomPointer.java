package linkedlist;

import java.util.*;

/**
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.

 The Linked List is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

 val: an integer representing Node.val
 random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it does not point to any node.


 Example 1:


 Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 Example 2:


 Input: head = [[1,1],[2,1]]
 Output: [[1,1],[2,1]]
 Example 3:



 Input: head = [[3,null],[3,0],[3,null]]
 Output: [[3,null],[3,0],[3,null]]
 Example 4:

 Input: head = []
 Output: []
 Explanation: Given linked list is empty (null pointer), so return null.


 Constraints:

 -10000 <= Node.val <= 10000
 Node.random is null or pointing to a node in the linked list.
 Number of Nodes will not exceed 1000.

 */
public class CopyListWithRandomPointer {

    private static final Map<Node, Node> copiedRandoms = new HashMap<>();

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node copyRandomList(Node head) {
        if(head == null) return null;

        Node resultHead = new Node(0);
        Node result = resultHead;

        Map<Node, Node> nodeMap = new HashMap<>();
        while(head != null) {
            Node node = null;
            if(nodeMap.containsKey(head)) {
                node = nodeMap.get(head);
            } else {
                node = new Node(head.val);
                nodeMap.put(head, node);
            }

            Node rand = null;
            if(head.random != null) {
                if(nodeMap.containsKey(head.random)) {
                    rand = nodeMap.get(head.random);
                } else {
                    rand = new Node(head.random.val);
                    nodeMap.put(head.random, rand);
                }
            }

            node.random = rand;
            result.next = node;
            result = result.next;
            head = head.next;
        }

        return resultHead.next;
    }

    public static void main(String[] args){
        // [[7,null],[13,0],[11,4],[10,2],[1,0]]

        Node first = new Node(7);
        Node second = new Node(13);
        Node third = new Node(11);
        Node fourth = new Node(10);
        Node fifth = new Node(1);

        first.next = second;
        first.random = null;
        second.next = third;
        second.random = first;
        third.next = fourth;
        third.random = fifth;
        fourth.next = fifth;
        fourth.random = third;
        fifth.random = first;

        Node deepCopy = copyRandomList(first);
        System.out.println("Finished");

    }
}
