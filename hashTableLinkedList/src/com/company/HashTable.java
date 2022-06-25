package com.company;

// class for executing the hash table commands and whatnot
// I'm just gonna leave the load factor at 0.5
// Keys are integers and values are integers.

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTable {
    // the number of slots in the hash table
    private int capacity;
    // the number of elements in the hash table
    private int elements;
    // array of linked lists (to store collisions)
    List<LinkedList<Node>> indices;
    // size up the hash table when it's half full
    final double loadFactor = 0.5;

    // default constructor, capacity = 4
    public HashTable() {
        capacity = 4;
        // initiate the list of indices
        initiateIndices();
        // no elements
        elements = 0;
    }

    // constructor with a given capacity
    public HashTable(int givenCapacity) {
        // assign the capacity to the given capacity
        capacity = givenCapacity;
        // initiate the lists of indices
        initiateIndices();
        // no elements
        elements = 0;
    }

    // this function is meant to return the hash of a key
    // or just modulo'ing the key with the capacity of the table
    public int computeHash(int key) {
        return key % capacity;
    }

    // adding an element to the hash table
    public void put(Node node) {
        // check if reload needed
        if (elements >= (capacity * loadFactor)) {
            reload();
        }
        // hash the key and use that as an index
        int index = computeHash(node.getKey());
        // get the linked list at a specific index
        LinkedList<Node> list = indices.get(index);
        // add that value to the linked list
        list.add(node);
        // increment the number of elements up
        elements++;
    }

    // reload the contents of the hash table
    public void reload() {
        // double the capacity
        capacity = capacity * 2;

        // create a temporary list to store all the previous nodes
        List<Node> tempNodeList = new ArrayList<Node>();

        // iterate through the linked lists of nodes,
        // add the nodes to the temporary list,
        // empty the contents of the linked list
        for(LinkedList<Node> list : indices) {
            tempNodeList.addAll(list);
            list.clear();
        }
        // initiate the lists of indices once more
        initiateIndices();

        // add all the nodes in the temporary list to the hash table
        elements = 0;
        for(Node node : tempNodeList) {
            put(node);
        }
    }

    // print the hash table
    public void print() {
        // index counter
        int count = 0;
        for (LinkedList<Node> list : indices) {
            // print index message
            System.out.print("index " + count + ": ");
            // print all nodes in the list at that index
            for (Node node : list) {
                System.out.print(node.getValue() + " ");
            }
            // newline at end
            System.out.println();
            // increment up index count
            count++;
        }
    }

    // initiates the array of indices with linked lists
    public void initiateIndices() {
        indices = new ArrayList<LinkedList<Node>>();
        for(int i = 0; i < capacity; i++) {
            indices.add(new LinkedList<Node>());
        }
    }

    // function to empty the table and reset the capacity
    public void emptyTable() {
        // reset to default capacity
        capacity = 4;
        // set elements to 0
        elements = 0;
        // get rid of the previously created linkedlists
        initiateIndices();
    }
}
