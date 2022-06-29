package com.company;

// This is another guy's implementation of the Number of Sub-arrays of Size K and Average Greater
// than or Equal to Threshold problem on LeetCode.

// I attempted to solve it, but sadly, I was not able to figure it out in a timely fashion.

// COOL FACT: This problem falls under the Sliding Window category of the 14 patterns of LeetCode probs.

// DESCRIPTION
// Given an array of integers arr and two integers k and threshold, return the number of sub-arrays
// of size k and average greater than or equal to threshold.
public class Main {

    public static void main(String[] args) {
	    int[] arr = {2, 7, 18, 2, 4, 5};
	    System.out.println(numOfSubarrays(arr, 3, 5));
    }

    // optimized code to find the subarrays that avg to be grt or equ to threshold
    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        // calculate average of first k elements
        int num = 0;    // counter
        int sum = 0;    // sum
        // calculate sum
        for(int i = 0; i < k; i++) {
            sum += arr[i];
        }
        // calculate average
        int avg = sum / k;
        // check if average meets requirements, adjust counter
        if (avg >= threshold)
            num++;

        // check rest
        for (int j = k; j < arr.length; j++) {
            // get rid of first number added
            sum -= arr[j-k];
            // add newest number
            sum += arr[j];
            // get avg
            avg = sum / k;
            // check if average meets requirements, adjust counter
            if(avg >= threshold)
                num++;
        }
        // return counter
        return num;

    }
}
