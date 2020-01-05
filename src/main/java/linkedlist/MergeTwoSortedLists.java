package linkedlist;

public class MergeTwoSortedLists {

    static public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        ListNode mergedList = null;
        ListNode headMergedList = null;
        while(l1 != null){
            boolean l1Merged = false;
            while (l2 != null && !(l1.next != null && l1.next.val <= l2.val)){
                if(l1.val <= l2.val){
                    if(mergedList == null){
                        mergedList = new ListNode(l1.val);
                        headMergedList = mergedList;
                        mergedList.next = new ListNode(l2.val);
                        mergedList = mergedList.next;
                        l2 = l2.next;
                        l1Merged = true;
                        break;
                    } else {
                        mergedList.next = new ListNode(l1.val);
                        mergedList = mergedList.next;

                        mergedList.next = new ListNode(l2.val);
                        mergedList = mergedList.next;
                        l2 = l2.next;
                        l1Merged = true;
                        break;
                    }
                } else {
                    if(mergedList == null){
                        mergedList = new ListNode(l2.val);
                        headMergedList = mergedList;
                        l2 = l2.next;
                    } else {
                        mergedList.next = new ListNode(l2.val);
                        mergedList = mergedList.next;
                        l2 = l2.next;
                    }
                }
            }
            if(!l1Merged) {
                if (mergedList == null) {
                    mergedList = new ListNode(l1.val);
                    headMergedList = mergedList;
                } else {
                    mergedList.next = new ListNode(l1.val);
                    mergedList = mergedList.next;
                }
            }
            l1 = l1.next;
        }

        while (l2 != null){
            if (mergedList == null) {
                mergedList = new ListNode(l2.val);
                headMergedList = mergedList;
            } else {
                mergedList.next = new ListNode(l2.val);
                mergedList = mergedList.next;
            }
            l2 = l2.next;
        }
        return headMergedList;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       // 1 1 2 5 6 7 10
        // 2 3 4 8 9

        // 1
        if(l1 == null){
            return l2;
        } else if(l2 == null){
            return l1;
        } else {
            if(l1.val <= l2.val){
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }

    // 1 1

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);

        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(1);
        ListNode seven = new ListNode(1);
        ListNode eight = new ListNode(2);
        ListNode nine = new ListNode(5);
        ListNode ten = new ListNode(6);

        l1.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        //five.next = six;

        l2.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = ten;

        ListNode mergedList = mergeTwoLists(l1, l2);
        System.out.println(String.format("mergedList: %s", mergedList));

    }
}
