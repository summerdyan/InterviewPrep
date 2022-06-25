package com.company;

// This will be personal implementation of a hash table (based off of CTCI docs - page 90)
// Okay I'm not going to do a full Java implementation of a linked list, I'll use Java's class.
// TOMORROW, I will be doing my own implementation of a linked list.
// It's fun how I can just keep working backwards with things haha.

// The Main class just serves as a way for me to test out my hash table implementation.

public class Main {

    public static void main(String[] args) {
        // creating an instance of the HashTable
        HashTable ht = new HashTable();

        // add values to ht
        Node node = new Node(5, 14);
        ht.put(node);
        node = new Node(1, 2);
        ht.put(node);
        node = new Node(25, 6);
        ht.put(node);
        node = new Node(40, 1);
        ht.put(node);
        node = new Node(3, 8);
        ht.put(node);
        node = new Node(1, 8);
        ht.put(node);

        // print
        ht.print();

        // empty the hash table
        ht.emptyTable();

        // print
        System.out.println(); // newline
        ht.print();
    }
}
