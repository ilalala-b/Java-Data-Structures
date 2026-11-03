package assignment2;

/**
 * A fixed-capacity max heap of integers, implemented using a plain array.
 * The largest value is always kept at index 0.
 */
public class MaxHeap {
    private final int[] heap;
    private int size;

    /** Creates an empty max heap with the requested capacity. */
    // O(1)
    public MaxHeap(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        heap = new int[capacity];
        size = 0;
    }

    /** Adds a value and moves it upward until the max-heap rule is restored. */
    // O(log n)
    public void insert(int value) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }

        int index = size;
        heap[index] = value;

        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap[parent] >= heap[index]) {
                break;
            }
            swap(parent, index);
            index = parent;
        }
        size++;
    }

    /** Returns the maximum value without removing it. */
    // O(1)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty; no maximum value is available");
        }
        return heap[0];
    }

    /** Removes and returns the maximum value. */
    // O(log n)
    public int extractMax() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty; cannot extract a maximum value");
        }

        int maximum = heap[0];
        int lastValue = heap[size - 1];
        size--;

        if (size > 0) {
            heap[0] = lastValue;
            bubbleDown(0);
        }
        return maximum;
    }

    /** Returns an index of value in the backing array, or -1 if not found. */
    // O(n)
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (heap[i] == value) {
                return i;
            }
        }
        return -1;
    }

    /** Returns true if the value exists in the heap's active array section. */
    // O(n)
    public boolean contains(int value) {
        return search(value) != -1;
    }

    /** Returns true when no elements are stored. */
    // O(1)
    public boolean isEmpty() {
        return size == 0;
    }

    /** Returns true when all array slots are in use. */
    // O(1)
    public boolean isFull() {
        return size == heap.length;
    }

    /** Returns the number of elements currently stored. */
    // O(1)
    public int size() {
        return size;
    }

    /** Makes the heap logically empty while keeping its allocated capacity. */
    // O(1)
    public void clear() {
        size = 0;
    }

    /** Prints the heap's active array section (heap order, not sorted order). */
    // O(n)
    public void display() {
        System.out.println(toString());
    }

    // O(n)
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(heap[i]);
            if (i < size - 1) {
                result.append(", ");
            }
        }
        result.append(']');
        return result.toString();
    }

    /** Moves a value down by swapping it with its larger child when needed. */
    // O(log n)
    private void bubbleDown(int index) {
        while (true) {
            int leftChild = 2 * index + 1;
            int rightChild = 2 * index + 2;
            int largest = index;

            if (leftChild < size && heap[leftChild] > heap[largest]) {
                largest = leftChild;
            }
            if (rightChild < size && heap[rightChild] > heap[largest]) {
                largest = rightChild;
            }
            if (largest == index) {
                return;
            }

            swap(index, largest);
            index = largest;
        }
    }

    /** Swaps two values in the backing array. */
    // O(1)
    private void swap(int first, int second) {
        int temporary = heap[first];
        heap[first] = heap[second];
        heap[second] = temporary;
    }
}