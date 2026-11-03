package assignment2;

/**
 * A reusable singly linked list of integers, implemented from scratch.
 * The list keeps both head and tail references so adding at the end is O(1).
 */
public class SinglyLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /** Represents one item in the list. */
    private static class Node {
        private int data;
        private Node next;

        // O(1)
        private Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    /** Creates an empty list. */
    // O(1)
    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Adds a value to the end of the list. */
    // O(1)
    public void add(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /** Adds a value to the beginning of the list. */
    // O(1)
    public void addFirst(int value) {
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;

        if (size == 0) {
            tail = newNode;
        }
        size++;
    }

    /**
     * Inserts a value at a zero-based index. Valid indices are 0 through size.
     */
    // O(n) general case; O(1) at index 0 or size
    public void insert(int index, int value) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is invalid for insertion; valid range is 0 to " + size);
        }

        if (index == 0) {
            addFirst(value);
            return;
        }
        if (index == size) {
            add(value);
            return;
        }

        Node previous = nodeAt(index - 1);
        Node newNode = new Node(value);
        newNode.next = previous.next;
        previous.next = newNode;
        size++;
    }

    /** Removes and returns the value at a zero-based index. */
    // O(n) general case; O(1) at index 0
    public int remove(int index) {
        checkElementIndex(index);

        if (index == 0) {
            int removedValue = head.data;
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
            return removedValue;
        }

        Node previous = nodeAt(index - 1);
        Node removedNode = previous.next;
        previous.next = removedNode.next;
        if (removedNode == tail) {
            tail = previous;
        }
        size--;
        return removedNode.data;
    }

    /** Returns the value at a zero-based index without removing it. */
    // O(n)
    public int get(int index) {
        checkElementIndex(index);
        return nodeAt(index).data;
    }

    /** Replaces the value at a zero-based index. */
    // O(n)
    public void set(int index, int value) {
        checkElementIndex(index);
        nodeAt(index).data = value;
    }

    /** Returns the first index of value, or -1 if the value is not present. */
    // O(n)
    public int search(int value) {
        Node current = head;
        int index = 0;

        while (current != null) {
            if (current.data == value) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /** Returns true if the value occurs in the list. */
    // O(n)
    public boolean contains(int value) {
        return search(value) != -1;
    }

    /** Returns true when the list has no elements. */
    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns the number of elements in the list. */
    // O(1)
    public int size() {
        return size;
    }

    /** Removes all elements by resetting the list references and size. */
    // O(1)
    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    /** Prints the list from head to tail. */
    // O(n)
    public void display() {
        System.out.println(toString());
    }

    // O(n)
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            result.append(current.data);
            current = current.next;
            if (current != null) {
                result.append(" -> ");
            }
        }
        result.append(']');
        return result.toString();
    }

    /** Returns the node at a known-valid index. */
    // O(n)
    private Node nodeAt(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    /** Checks whether an index refers to an existing element. */
    // O(1)
    private void checkElementIndex(int index) {
        if (index < 0 || index >= size) {
            if (size == 0) {
                throw new IndexOutOfBoundsException(
                        "List is empty; there is no valid element index");
            }
            throw new IndexOutOfBoundsException(
                    "Index " + index + " is invalid; valid range is 0 to " + (size - 1));
        }
    }
}