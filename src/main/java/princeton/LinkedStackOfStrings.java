package princeton;

import java.util.EmptyStackException;

/*
 * Implementation of stack using Linked List
 */
public class LinkedStackOfStrings {
    public static void main(String[] args) {
        int capacity = 3;
        LinkedStackOfStringsSolution stack = new LinkedStackOfStringsSolution(capacity);
        stack.push("1");
        System.out.println(stack.toString());
        stack.push("2");
        System.out.println(stack.toString());
        System.out.printf("pop - %s\n", stack.pop());
        System.out.println(stack.toString());
        stack.push("3");
        System.out.printf("pop - %s\n", stack.pop());
        System.out.printf("pop - %s\n", stack.pop());
        System.out.println(stack.toString());
    }
}

class LinkedStackOfStringsSolution {
    private Node first = null;
    private int size = 0;
    private int capacity = 0;

    private class Node {
        String item;
        Node next;

        Node(String item) {
            this.item = item;
        }
    }

    LinkedStackOfStringsSolution() {
    }

    LinkedStackOfStringsSolution(int capacity) {
        this.capacity = capacity;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String pop() {
        if (!isEmpty()) {
            String item = first.item;
            first = first.next;
            size--;
            return item;
        }
        throw new EmptyStackException();
    }

    public String push(String s) {
        if (first == null) {
            first = new Node(s);
        } else if (size < capacity) {
            Node oldFirst = first;
            first = new Node(s);
            first.next = oldFirst;
        } else {
            throw new StackOverflowError();
        }
        size++;
        return s;
    }

    public String toString() {
        Node ptr = first;
        StringBuilder retVal = new StringBuilder();
        while (ptr != null) {
            retVal.append(ptr.item);
            ptr = ptr.next;
            if (ptr == null) break;
            retVal.append(", ");
        }
        return retVal.toString();
    }
}