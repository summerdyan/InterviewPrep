package com.company;

// I'm subscribed to a LeetCode top 100 questions email list, and this was on the first email.

// DESCRIPTION
// You are given an array prices where prices[i] is the price of a given stock on the ith day.
// You want to maximize your profit by choosing a single day to buy one stock and choosing a
// different day in the future to sell that stock.
// Return the maximum profit you can achieve from this transaction. If you cannot achieve any
// profit, return 0.

public class Main {

    public static void main(String[] args) {
        int[] prices = {6, 5, 3, 8, 9, 4};
        System.out.println(maxProfit(prices));
    }

    // optimized implementation of choosing when to buy
    // and sell stocks to get the maximum profit
    // Time Complexity = O(n)
    public static int maxProfit(int[] prices) {
        // max profit
        int answer = 0;
        // minimum value so far
        int minimumSoFar = prices[0];
        // variable to store temporary profit
        int profit;
        // iterate through prices array
        for(int i = 1; i < prices.length; i++) {
            // find profit
            profit = prices[i] - minimumSoFar;
            // evaluate if it's max profit
            if(profit > answer) {
                answer = profit;
            }
            // find minimum between minimum so far and current price
            minimumSoFar = Math.min(minimumSoFar, prices[i]);
        }
        // return the generated max profit
        return answer;
    }
}
