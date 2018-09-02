package leetcode;

public class LinkedListImplementation {
    public static void main(String[] args) {
        SinglyLinkedListImplementationSolution sll = new SinglyLinkedListImplementationSolution();
        System.out.println("Add head: " + 1);
        sll.addAtHead(1);
//        System.out.println("Add tail: "+3);
//        sll.addAtTail(3);
        System.out.println("Add at index 1 : " + 2);
        sll.addAtIndex(1, 2);
        System.out.println("Val at 2: " + sll.get(2));
        /*System.out.println("Delete at index 1");
        sll.deleteAtIndex(1);
        System.out.println("Delete at index 0");
        sll.deleteAtIndex(0);
        System.out.println("Add head: "+1);
        sll.addAtHead(1);
        System.out.println("Delete at index 1");
        sll.deleteAtIndex(1);
        System.out.println("Add tail: "+3);
        sll.addAtTail(3);
        System.out.println("Add at index 1 : "+2);
        sll.addAtIndex(1,2);*/
    }
}

class SinglyLinkedListImplementationSolution {
    int length;
    private Node head;
    private Node tail;

    private static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    /**
     * Initialize your data structure here.
     */
    SinglyLinkedListImplementationSolution() {
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    int get(int index) {
        Node ptr = head;
        for (int i = 0; i < length; i++) {
            if (i == index) {
                return ptr.val;
            }
            ptr = ptr.next;
        }
        printList();
        return -1;
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    void addAtHead(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
            length++;
            printList();
            return;
        }
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
        length++;
        printList();
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    void addAtTail(int val) {
        if (tail == null) {
            tail = new Node(val);
            head = tail;
            length++;
            printList();
            return;
        }
        Node newNode = new Node(val);
        tail.next = newNode;
        tail = newNode;
        length++;
        printList();
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    void addAtIndex(int index, int val) {
        if (index == 0) {
            addAtHead(val);
            return;
        } else if (index == length) {
            addAtTail(val);
            return;
        }
        Node prevPtr = head;
        for (int i = 1; i < length; i++) {
            if (i == index) {
                Node newNode = new Node(val);
                newNode.next = prevPtr.next;
                prevPtr.next = newNode;
                length++;
                printList();
                return;
            }
            prevPtr = prevPtr.next;
        }
        printList();
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index) {
        Node temp;
        if (index > length - 1) {
            printList();
            return;
        } else if (index == 0 && head != null) {
            temp = head;
            head = head.next;
            temp.next = null;
            length--;
            printList();
            return;
        } else if (index == length - 1 && tail != null) {
            temp = head;
            if (temp != null) {
                for (int i = 0; i < length; i++) {
                    if (i == length - 2) {
                        temp.next = null;
                        tail = temp;
                        length--;
                        printList();
                        return;
                    }
                    temp = temp.next;
                }
            }
        } else {
            Node ptr = head;
            for (int i = 0; i < length && ptr != null; i++) {
                if (i == index - 1) {
                    temp = ptr.next;
                    ptr.next = temp.next;
                    temp.next = null;
                    length--;
                    printList();
                    return;
                }
                ptr = ptr.next;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder list = new StringBuilder();
        Node ptr = head;
        while (ptr != null) {
            list.append(ptr.val).append(" -> ");
            ptr = ptr.next;
        }
        list.append(" null\n");
        return list.toString();
    }

    private void printList() {
        System.out.println("List: " + toString() + " size: " + length);
    }
}
