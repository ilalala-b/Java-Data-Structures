# Java Data Structures: Linked List & Max Heap

A from-scratch implementation of two fundamental data structures in Java: a **Singly Linked List** (Linear) and a **Max Heap** (Non-Linear). This project was built to demonstrate core computer science concepts, memory management, and algorithmic complexity.

*(Note: This project was originally developed as part of a university course on Comprehensive Design of Data Structures - CDoDS).*

## 📋 Overview

| Data Structure | Type | Backing Structure |
| :--- | :--- | :--- |
| **Singly Linked List** | Linear | Custom `Node` chain (head + tail references) |
| **Max Heap** | Non-Linear (Tree) | Fixed-size array-backed binary heap |

## ✨ Features & Implementations

### 1. Singly Linked List (Linear)
Implemented with both `head` and `tail` references to optimize end-of-list operations.
*   `add(value)` — O(1) append to tail
*   `addFirst(value)` — O(1) insert at head
*   `insert(index, value)` — O(n) insert at arbitrary position
*   `remove(index)` — O(n) remove by index
*   `get(index)` / `set(index, value)` — O(n) access
*   `search(value)` / `contains(value)` — O(n) linear search
*   *Error Handling:* Throws `IndexOutOfBoundsException` for invalid indices.

### 2. Max Heap (Non-Linear)
A fixed-capacity array-backed implementation where the maximum value is always kept at the root (index 0).
*   `insert(value)` — O(log n) bubble-up
*   `extractMax()` — O(log n) bubble-down
*   `peek()` — O(1) maximum value
*   `search(value)` / `contains(value)` — O(n)
*   *Error Handling:* Throws `IllegalArgumentException` (invalid capacity) and `IllegalStateException` (empty/full heap).

## 🚀 How to Run

1. Clone the repository.
2. Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
3. Run the `Main.java` file to see the demonstration of normal operations and error cases.

```bash
javac *.java
java assignment2.Main# Java-Data-Structures
Custom implementations of a Singly Linked List (Linear) and a Max Heap (Non-Linear) in Java, featuring full operations, proper error handling, and O(n) complexity analysis.
