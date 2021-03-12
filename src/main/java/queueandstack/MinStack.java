package queueandstack;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.


Example:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin();   --> Returns -3.
minStack.pop();
minStack.top();      --> Returns 0.
minStack.getMin();   --> Returns -2.

 */
public class MinStack {

    private int size;
    private List<Integer> items;

    /** initialize your data structure here. */
    public MinStack() {
        this.size = 0;
        this.items = new ArrayList<>();
    }

    public void push(int x) {
        items.add(x);
        size++;
    }

    public void pop() {
        if(size > 0) {
            items.remove(size - 1);
            size--;
        } else {
            throw new NoSuchElementException();
        }
    }

    public int top() {
        if(size > 0 ) {
            return items.get(size - 1);
        }
        throw new NoSuchElementException();
    }

    public int getMin() {
        Integer min = Integer.MAX_VALUE;
        for(Integer item: items){
            if(min > item){
                min = item;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);

        System.out.println(String.format("[-2,0,-3] Min: %s", minStack.getMin()));
        minStack.pop();
        System.out.println(String.format("[-2,0]: Top: %s",minStack.top()));
        System.out.println(String.format("[-2,0]: Min: %s",minStack.getMin()));
    }

}
