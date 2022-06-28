package com.company;

// This is my implementation of the SingleNumber problem on LeetCode (as well as an optimizied solution).

// DESCRIPTION
// Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
// You must implement a solution with a linear runtime complexity and use only constant extra space.

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 3, 4, 5, 4, 5};
        System.out.println(mySingleNumber(nums));
        System.out.println(optimizedSingleNumber(nums));
    }

    // my implementation involves sorting the array first then finding which number
    // doesn't have the same number next to it - around O(n) time
    public static int mySingleNumber(int[] nums) {
        // sort the array, prob only O(n)
        Arrays.sort(nums);
        // check and see if the numbers close together are the same
        for(int i = 1; i < nums.length; i += 2) {
            // if not the same, return the number
            if(nums[i] != nums[i - 1])
                return nums[i-1];
        }
        // if nothing found, return end
        return nums[nums.length - 1];
    }

    // The optimized version of this solution requires some background.
    // THE XOR OPERATOR (fireworks)
    // 1) a ^ a = 0
    // 2) a ^ 0 = a
    // 3) a ^ b = b ^ a

    // So if we XOR all the values in the array together a lot of values would
    // XOR to 0 because they'd be the same. Then we'd get 0 XOR'd with whatever
    // value didn't have a duplicate. Meaning we would get that value as the result.

    // EXAMPLE
    // [1, 3, 1, 2, 4, 2, 4]
    // 1 ^ 3 ^ 1 ^ 2 ^ 4 ^ 2 ^ 4
    // (1 ^ 1) ^ (2 ^ 2) ^ (3) ^ (4 ^ 4)
    // 0 ^ 0 ^ 3 ^ 0
    // 0 ^ 3
    // 3

    // implementation of this bitwise XOR across the array
    public static int optimizedSingleNumber(int[] nums) {
        // set answer to 0 because 0 ^ anything = anything
        int ans = 0;
        // iterate through values in array and XOR
        for(int num : nums) {
            ans = ans ^ num;
        }
        // return the answer
        return ans;
    }
}
