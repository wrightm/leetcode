package queueandstack;

public class MyCircularQueue {

    private final int[] items;
    private int start;
    private int end;
    private int size;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        this.items = new int[k];
        this.start = 0;
        this.end = -1;
        this.size = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size == items.length){
            return false;
        }

        if(end < items.length - 1){
            end++;
            size++;
            items[end] = value;
        } else {
            end = 0;
            size++;
            items[end] = value;
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size == 0){
            start = 0;
            end = -1;
            return false;
        }
        if(start == items.length - 1){
            start = 0;
            size--;
        } else {
            start++;
            size--;
        }
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (size <= 0){
            return -1;
        }
        return items[start];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (size <= 0){
            return -1;
        }
        return items[end];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == items.length;
    }

    public static void main(String[] args){
        MyCircularQueue queue = new MyCircularQueue(5);
        System.out.println(String.format("enQueue = 1 == %s", queue.enQueue(1)));
        System.out.println(String.format("enQueue = 2 == %s", queue.enQueue(2)));
        System.out.println(String.format("enQueue = 3 == %s", queue.enQueue(3)));
        System.out.println(String.format("enQueue = 4 == %s", queue.enQueue(4)));
        System.out.println(String.format("enQueue = 5 == %s", queue.enQueue(5)));

        System.out.println(String.format("This should fail: enQueue = 1 == %s", queue.enQueue(6)));

        System.out.println(String.format("Front:  %s", queue.Front()));
        System.out.println(String.format("Rear:  %s", queue.Rear()));

        System.out.println(String.format("deQueue == %s", queue.deQueue()));

        System.out.println(String.format("Front:  %s", queue.Front()));
        System.out.println(String.format("Rear:  %s", queue.Rear()));


        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));

        System.out.println(String.format("Front:  %s", queue.Front()));
        System.out.println(String.format("Rear:  %s", queue.Rear()));

        System.out.println(String.format("enQueue = 1 == %s", queue.enQueue(1)));
        System.out.println(String.format("enQueue = 2 == %s", queue.enQueue(2)));
        System.out.println(String.format("enQueue = 3 == %s", queue.enQueue(3)));
        System.out.println(String.format("enQueue = 4 == %s", queue.enQueue(4)));
        System.out.println(String.format("enQueue = 5 == %s", queue.enQueue(5)));

        System.out.println(String.format("Front:  %s", queue.Front()));
        System.out.println(String.format("Rear:  %s", queue.Rear()));

        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));

        System.out.println(String.format("enQueue = 4 == %s", queue.enQueue(4)));
        System.out.println(String.format("enQueue = 5 == %s", queue.enQueue(6)));
        System.out.println(String.format("enQueue = 4 == %s", queue.enQueue(7)));
        System.out.println(String.format("enQueue = 5 == %s", queue.enQueue(8)));

        System.out.println(String.format("Front:  %s", queue.Front()));
        System.out.println(String.format("Rear:  %s", queue.Rear()));

        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));
        System.out.println(String.format("deQueue == %s", queue.deQueue()));

        System.out.println(String.format("Front:  %s", queue.Front()));
        System.out.println(String.format("Rear:  %s", queue.Rear()));

        System.out.println(String.format("isEmpty:  %s", queue.isEmpty()));
        System.out.println(String.format("isFull:  %s", queue.isFull()));

        System.out.println(String.format("deQueue == %s", queue.deQueue()));

        System.out.println(String.format("enQueue = 1 == %s", queue.enQueue(1)));
        System.out.println(String.format("enQueue = 2 == %s", queue.enQueue(2)));
        System.out.println(String.format("enQueue = 3 == %s", queue.enQueue(3)));
        System.out.println(String.format("enQueue = 4 == %s", queue.enQueue(4)));
        System.out.println(String.format("enQueue = 5 == %s", queue.enQueue(5)));

        System.out.println(String.format("isEmpty:  %s", queue.isEmpty()));
        System.out.println(String.format("isFull:  %s", queue.isFull()));

        System.out.println(String.format("enQueue = 5 == %s", queue.enQueue(6)));
    }
}
