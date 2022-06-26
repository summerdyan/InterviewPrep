package com.company;

// My implementation of the two sum problem that is often used in interviews.
// Given an array of integers, find two numbers such that they add up to a specific target number.

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 6};
        int target = 5;
        System.out.println(Arrays.toString(optimizedTwoSum(array, target)));
    }

    // find two numbers such that they add up to a target number
    // return the indices of those two numbers where index1 is less than index2
    // index1 and index2 should NOT be zero based
    // you may assume each input will have exactly ONE input

    // my approach was brute force and has a time complexity of O(n^2) and O(1) space - not great
    public static int[] myTwoSum(int[] array, int target) {
        int[] solution = new int[2];
        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {
                if(array[i] + array[j] == target) {
                    solution[0] = i + 1;
                    solution[1] = j + 1;
                }
            }
        }
        return solution;
    }

    // optimized two sum using a hash map
    // O(n) runtime and O(n) space - pretty good
    public static int[] optimizedTwoSum(int[] array, int target) {
        // create a hash map to store indices and values
        Map<Integer, Integer> map = new HashMap<>();
        // iterate through values in array
        for(int i = 0; i < array.length; i++) {
            // check if map contains the current value's distance away from target
            if(map.containsKey(target - array[i])) {
                // return the found index and the current index that add to target
                // values are being added to the map so the one you find comes from previous
                // part of the array
                return new int[] {map.get(target - array[i]) + 1, i + 1};
            }
            // put the array value and index into the map if solution set hasn't been found
            map.put(array[i], i);
        }
        // if not found, return null
        return null;
    }
}
