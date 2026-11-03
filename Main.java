package assignment2;

/** Demonstrates normal operations and error cases for both data structures. */
public class Main {
    public static void main(String[] args) {
        demonstrateSinglyLinkedList();
        demonstrateMaxHeap();
    }

    private static void demonstrateSinglyLinkedList() {
        System.out.println("========== SINGLY LINKED LIST ==========");
        SinglyLinkedList list = new SinglyLinkedList();
        System.out.println("New list is empty: " + list.isEmpty());

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        System.out.print("After add(10, 20, 30, 40): ");
        list.display();

        list.insert(2, 25);
        System.out.print("After insert(2, 25): ");
        list.display();

        list.addFirst(5);
        System.out.print("After addFirst(5): ");
        list.display();

        System.out.println("get(3): " + list.get(3));
        list.set(3, 27);
        System.out.print("After set(3, 27): ");
        list.display();
        System.out.println("search(30): " + list.search(30));
        System.out.println("search(999): " + list.search(999));
        System.out.println("contains(20): " + list.contains(20));
        System.out.println("Current size: " + list.size());

        System.out.println("remove(0) returned: " + list.remove(0));
        System.out.print("After removing first item: ");
        list.display();
        System.out.println("remove(2) returned: " + list.remove(2));
        System.out.print("After removing index 2: ");
        list.display();
        System.out.println("remove(last index) returned: " + list.remove(list.size() - 1));
        System.out.print("After removing last item: ");
        list.display();
        System.out.println("Size after removals: " + list.size());

        try {
            list.get(-1);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught invalid get: " + e.getMessage());
        }

        try {
            list.insert(list.size() + 1, 88);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught invalid insert: " + e.getMessage());
        }

        list.clear();
        System.out.print("After clear(): ");
        list.display();
        System.out.println("Empty after clear: " + list.isEmpty());

        try {
            list.remove(0);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caught remove from empty list: " + e.getMessage());
        }
        System.out.println();
    }

    private static void demonstrateMaxHeap() {
        System.out.println("========== MAX HEAP ==========");

        try {
            new MaxHeap(0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught invalid capacity: " + e.getMessage());
        }

        MaxHeap heap = new MaxHeap(5);
        System.out.println("New heap is empty: " + heap.isEmpty());
        heap.insert(40);
        heap.insert(15);
        heap.insert(30);
        heap.insert(10);
        heap.insert(5);
        System.out.print("After inserting 40, 15, 30, 10, 5: ");
        heap.display();

        System.out.println("peek(): " + heap.peek());
        System.out.println("contains(15): " + heap.contains(15));
        System.out.println("contains(99): " + heap.contains(99));
        System.out.println("search(15): " + heap.search(15));
        System.out.println("search(99): " + heap.search(99));
        System.out.println("Current size: " + heap.size());
        System.out.println("extractMax() returned: " + heap.extractMax());
        System.out.print("Heap after extractMax(): ");
        heap.display();

        heap.insert(20);
        System.out.print("After insert(20): ");
        heap.display();
        System.out.println("Heap is full: " + heap.isFull());

        try {
            heap.insert(99);
        } catch (IllegalStateException e) {
            System.out.println("Caught insert into full heap: " + e.getMessage());
        }

        heap.clear();
        System.out.print("After clear(): ");
        heap.display();
        System.out.println("Empty after clear: " + heap.isEmpty());

        try {
            heap.peek();
        } catch (IllegalStateException e) {
            System.out.println("Caught peek on empty heap: " + e.getMessage());
        }

        try {
            heap.extractMax();
        } catch (IllegalStateException e) {
            System.out.println("Caught extractMax on empty heap: " + e.getMessage());
        }
    }
}