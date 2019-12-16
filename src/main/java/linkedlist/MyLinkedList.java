package linkedlist;

public class MyLinkedList {

    static private class Node {
        private Node prev;
        private Node next;
        private int value;
    }

    private Node last;
    private Node first;
    private Node head;
    private int count;

    public MyLinkedList(){
        this.head = new Node();
        this.count = 0;
    }

    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(count-1 < index || index < 0){
            return -1;
        }
        Node current = first;
        int currentIndex = 0;
        while(current.next != null){
            if(currentIndex == index){
                return current.value;
            }
            currentIndex++;
            current = current.next;
        }

        return -1;
    }

    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node f = first;
        Node current = new Node();
        current.value = val;
        current.next = f;
        first = current;
        first.prev = head;

        if(f == null){
            last = current;
            last.next = head;
        } else {
            f.prev = current;
        }
        count++;
    }

    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node l = last;
        Node current = new Node();
        current.value = val;
        current.prev = l;
        current.next = head;
        last = current;

        if(l==null){
            first = current;
            first.prev = head;
        } else {
            l.next = current;
        }
        count++;
    }

    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(count < index || index < 0){
            return;
        }
        if(count == index) {
            addAtTail(val);
            return;
        }

        Node current = first;
        int currentIndex = 0;
        while(current.next != null){
            if(currentIndex == index){
                Node node = new Node();
                node.value = val;
                if(current.next.next == null && current.prev.prev == null) {
                    addAtHead(val);
                } else if(current.next.next == null){
                    Node prev = current.prev;
                    current.prev = node;
                    node.next = current;
                    node.prev = prev;
                    prev.next = node;
                    count++;
                } else if (current.prev.prev == null){
                    addAtHead(val);
                } else {
                    Node prev = current.prev;
                    prev.next = node;
                    node.next = current;
                    node.prev = prev;
                    current.prev = node;
                    count++;
                }
                return;
            }
            currentIndex++;
            current = current.next;
        }
    }

    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(count-1 < index || index < 0){
            return;
        }

        Node current = first;
        int currentIndex = 0;
        while(current.next != null){
            if(currentIndex == index){
                if(current.prev.prev == null){
                    current.next.prev = current.prev;
                    first = current.next;
                } else if(current.next.next == null){
                    current.prev.next = current.next;
                    last = current.prev;
                } else {
                    Node prev = current.prev;
                    prev.next = current.next;
                    current.next.prev = prev;
                }
                count--;
                return;
            }
            currentIndex++;
            current = current.next;
        }
    }

    public static void main(String[] args){
//        LinkedList
        MyLinkedList numbers = new MyLinkedList();
        numbers.addAtTail(1);
        numbers.addAtTail(1);
        numbers.addAtTail(2);
        numbers.addAtTail(3);
        numbers.addAtHead(4);
        numbers.addAtIndex(0, 10);
        numbers.addAtIndex(5, 3);
        numbers.addAtIndex(3, 7);

        Node current = numbers.first;
        while(current.next != null){
            System.out.println(String.format("Value = %s", current.value));
            current = current.next;
        }

        numbers.deleteAtIndex(0);
        numbers.deleteAtIndex(6);
        numbers.deleteAtIndex(2);

        current = numbers.first;
        while(current.next != null){
            System.out.println(String.format("Value = %s", current.value));
            current = current.next;
        }

        System.out.println(String.format("-1 index = %s", numbers.get(-1)));
        System.out.println(String.format("0 index = %s", numbers.get(0)));
        System.out.println(String.format("1 index = %s", numbers.get(1)));
        System.out.println(String.format("2 index = %s", numbers.get(2)));
        System.out.println(String.format("3 index = %s", numbers.get(3)));
        System.out.println(String.format("4 index = %s", numbers.get(4)));
        System.out.println(String.format("5 index = %s", numbers.get(5)));

        System.out.println("--------------------------------------------------------------------------");


        MyLinkedList obj = new MyLinkedList();
        obj.addAtHead(1);
        System.out.println(String.format("0 index = %s", obj.get(0)));
        obj.addAtTail(3);
        System.out.println(String.format("1 index = %s", obj.get(1)));
        obj.addAtIndex(1,2);
        System.out.println(String.format("1 index = %s", obj.get(1)));
        obj.deleteAtIndex(1);
        System.out.println(String.format("1 index = %s", obj.get(1)));




//        ["MyLinkedList","addAtHead","addAtHead","addAtHead","addAtIndex","deleteAtIndex","addAtHead","addAtTail","get","addAtHead","addAtIndex","addAtHead"]
//        [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]


        System.out.println("--------------------------------------------------------------------------");
        // 6 4 6 1 2 0 0 4
        MyLinkedList obj2 = new MyLinkedList();
        obj2.addAtHead(7); // 7
        obj2.addAtHead(2); // 2 7
        obj2.addAtHead(1); // 1 2 7
        obj2.addAtIndex(3, 0); // 1 2 7 0
        obj2.deleteAtIndex(2); // 1 2 0
        obj2.addAtHead(6); // 6 1 2 0
        obj2.addAtTail(4); // 6 1 2 0 4
        System.out.println(String.format("4 index = %s", obj2.get(4))); // 4
        obj2.addAtHead(4); // 4 6 1 2 0 4
        obj2.addAtIndex(5, 0); //  4 6 1 2 0 0 4
        obj2.addAtHead(6); // 6 4 6 1 2 0 0 4

        // ["MyLinkedList","addAtIndex","addAtIndex","addAtIndex","get"]
        // [[],[0,10],[0,20],[1,30],[0]]

        System.out.println("--------------------------------------------------------------------------");
        // 6 4 6 1 2 0 0 4
        MyLinkedList obj3 = new MyLinkedList();
        obj3.addAtIndex(0, 10); // 10
        obj3.addAtIndex(0, 20); // 20 10
        obj3.addAtIndex(1, 30); // 20 30 10
        System.out.println(String.format("4 index = %s", obj3.get(0))); // 4

    }
}
