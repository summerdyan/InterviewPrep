package com.company;

// Node class which will have both the key and value for the hash table

public class Node {
    // value and key variables
    private int key;
    private int value;

    // constructor
    Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    // setter methods
    public void setKey(int key) {
        this.key = key;
    }
    public void setValue(int value) {
        this.value = value;
    }

    // getter methods
    public int getKey() {
        return key;
    }
    public int getValue() {
        return value;
    }
}
