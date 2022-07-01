package com.company;

// LeetCode Problem
// DESCRIPTION
// A phrase is a palindrome if, after converting all uppercase letters into lowercase letters
// and removing all non-alphanumeric characters, it reads the same forward and backward.
// Alphanumeric characters include letters and numbers.
// Given a string s, return true if it is a palindrome, or false otherwise.

public class Main {

    public static void main(String[] args) {
	    String s = "racecar";
	    System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        // get rid of the spaces
        s = s.replaceAll(" ", "");
        s = s.toLowerCase();

        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            // find letter for start
            while((i < s.length()) && !Character.isLetterOrDigit(s.charAt(i)))
                i++;
            // find letter for end
            while((j > 0) && !Character.isLetterOrDigit(s.charAt(j)))
                j--;
            // check if they're the same
            if((i < j) && (s.charAt(i) != s.charAt(j))) {
                return false;
            }
            // increment and decrement
            i++;
            j--;
        }
        return true;
    }
}
