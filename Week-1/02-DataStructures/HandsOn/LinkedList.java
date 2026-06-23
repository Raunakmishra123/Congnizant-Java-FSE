package com.cognizant.datastructures;

// Singly Linked List - a chain of nodes where each node holds data
// and points to the next node.
//
//  [10] -> [20] -> [30] -> null
//
// Unlike arrays, linked lists don't need to be stored together in memory.
// Inserting at the beginning is O(1), but searching is O(n).

public class LinkedList<T> {

    private Node<T> head; // first node in the list
    private int size;

    // Each node stores data and a reference to the next node
    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    // Add to the front - very fast O(1)
    public void insertAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Add to the end - we have to walk to the last node, so O(n)
    public void insertAtEnd(T data) {
        Node<T> newNode = new Node<>(data);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Insert at a specific position
    public void insertAtPosition(int position, T data) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position!");
            return;
        }

        if (position == 0) {
            insertAtBeginning(data);
            return;
        }

        Node<T> newNode = new Node<>(data);
        Node<T> current = head;

        for (int i = 0; i < position - 1; i++) {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // Delete a node at a given position
    public T deleteAtPosition(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position!");
            return null;
        }

        T data;

        if (position == 0) {
            data = head.data;
            head = head.next;
        } else {
            Node<T> current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            data = current.next.data;
            current.next = current.next.next; // skip the node
        }

        size--;
        return data;
    }

    // Check if list contains a value
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // Print all elements in the list
    public void display() {
        Node<T> current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public int getSize() {
        return size;
    }
}

class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtEnd(30);
        list.display(); // 10 -> 20 -> 30 -> null

        list.insertAtBeginning(5);
        list.display(); // 5 -> 10 -> 20 -> 30 -> null

        list.insertAtPosition(2, 15);
        list.display(); // 5 -> 10 -> 15 -> 20 -> 30 -> null

        System.out.println("Contains 20? " + list.contains(20)); // true
        System.out.println("Contains 99? " + list.contains(99)); // false

        list.deleteAtPosition(2);
        list.display(); // 5 -> 10 -> 20 -> 30 -> null

        System.out.println("Size: " + list.getSize());
    }
}
