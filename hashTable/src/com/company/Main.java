package com.company;
import java.util.Hashtable;

// This class is just me implementing the Hashtable class in Java (easy mode).
// I will tomorrow create a hash table by using linked lists and a hashing function.

// NOTES ON HASH TABLES (taken from GeeksForGeeks):
// It's similar to a HashMap, but Hashtables are synchronized.
// Stores key/values pairs.
// We specify an object that's used as a key, value is associated with key.
// The key is hashed, and the resulting hash code is the index we store our
// value at in the table.

public class Main {

    public static void main(String[] args) {
        // BASIC HASHTABLE IMPLEMENTATION
        // creating a Hashtable with integer key and string values
        Hashtable<Integer, String> hashtable = new Hashtable<>();

        // inserting elements
        hashtable.put(1, "apple");
        hashtable.put(2, "banana");

        // printing the mappings of the hash table
        System.out.println("Mappings of the hash table: " + hashtable);

        // ADVANCED HASHTABLE IMPLEMENTATION
        // the first parameter sets the initial capacity of the hash table
        // the second parameter (from 0 to 1) determines how full the table gets
        // before being rehashed
        Hashtable<Integer, String> advHashtable = new Hashtable<>(5, 0.5f);

        advHashtable.put(1, "red");
        advHashtable.put(2, "green");
        advHashtable.put(3, "blue");

        // printing the mappings of the hash table
        System.out.println("Mappings of the hash table: " + advHashtable);

        // COPYING ANOTHER HASHTABLE
        // we can create a hashtable that contains the contents of another hashtable
        Hashtable<Integer, String> copyHashtable = new Hashtable<>(advHashtable);

        // printing the mappings of the hash table
        System.out.println("Mappings of the hash table: " + copyHashtable);
    }
}
