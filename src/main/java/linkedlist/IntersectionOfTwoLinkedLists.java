package linkedlist;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 *
 * For example, the following two linked lists:
 *
 *
 * begin to intersect at node c1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 *
 * Example 2:
 *
 *
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 *
 * Example 3:
 *
 *
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 *
 *
 * Notes:
 *
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionOfTwoLinkedLists {

    static public class ListNode {
     int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if(headA == headB){
            return headA;
        }

        ListNode outer = headA;
        ListNode inner = headB;
        while(outer != null){
            while(inner != null){
                if(outer == inner){
                    return outer;
                }
                inner = inner.next;
            }
            outer = outer.next;
            inner = headB;
        }
        return null;
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == headB){
            return headA;
        }

        int lengthA = 0;
        int lengthB = 0;
        ListNode nodeA = headA;
        ListNode nodeB = headB;

        while(nodeA != null){
            lengthA++;
            nodeA = nodeA.next;
        }

        while(nodeB != null){
            lengthB++;
            nodeB = nodeB.next;
        }

        ListNode shortNode = null;
        ListNode longNode = null;
        int diffInLength = 0;
        if(lengthA == 0 || lengthB == 0){
            return null;
        } else if(lengthA > lengthB){
            longNode = headA;
            shortNode = headB;
            diffInLength = lengthA - lengthB;
        } else {
            longNode = headB;
            shortNode = headA;
            diffInLength = lengthB - lengthA;
        }

        if(diffInLength > 0){
            int count = 0;
            while (count < diffInLength){
                longNode = longNode.next;
                count++;
            }
        }

        while (longNode != null && shortNode != null){
            if(longNode == shortNode){
                return longNode;
            }
            longNode = longNode.next;
            shortNode = shortNode.next;
        }
        return null;
    }


    public static void main(String[] args) {
        ListNode headA = new ListNode(0);

        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);

        headA.next = first;
        first.next = second;
        //second.next = third;
        //third.next = fourth;


        ListNode headB = new ListNode(0);

        ListNode firstB = new ListNode(1);
        ListNode secondB = new ListNode(2);
        ListNode thirdB = new ListNode(3);
        ListNode fourthB = new ListNode(4);

        headB.next = firstB;
        firstB.next = second;
        secondB.next = thirdB;
        thirdB.next = fourth;

        ListNode intersectionNode = getIntersectionNode(headA, headB);
        System.out.println(String.format("Has a intersect at %s", intersectionNode));
    }
}
