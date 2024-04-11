package com.example.test.p1_leetCode;

import java.util.HashMap;

public class C9_LongestSubarrayWithSum_K
{
    public static int longestSubarrayWithSumK(int[] array1, int k)
    {
        // HashMap to store cumulative sum and its corresponding index
        HashMap<Integer, Integer> sumIndices = new HashMap<>();
        int maximumLength = 0; // Variable to store the maximum length of subarray with sum K
        int currentSum = 0; // Variable to store the cumulative sum
        int n=array1.length;

        for (int i = 0; i <= (n-1); i++) // i from 0 to n-1
        {
            currentSum += array1[i]; // Update cumulative sum

            if (currentSum == k)
            {
                // If the sum is equal to K, update maxLen
                maximumLength = i + 1;
            } else if (sumIndices.containsKey(currentSum - k))
            {
                // If the difference between the current sum and K is present in the HashMap,
                // update maxLen based on the difference in indices
                maximumLength = Math.max(maximumLength, i - sumIndices.get(currentSum - k));
            }

            // If the current sum is not in the HashMap, add it with its index
            if (!sumIndices.containsKey(currentSum))
            {
                sumIndices.put(currentSum, i);
            }
        }

        return maximumLength;
    }

    public static void main(String[] args)
    {
        //int[] nums = {10, 5, 2, 7, 1, 9};
        int[] nums = {2, 0, 0, -1, -3, 1, 1, 1, 1, 1, 2, 1, 4};
        int k = 3;
        C9_LongestSubarrayWithSum_K longestSubarrayWithSum_K_obj1 = new C9_LongestSubarrayWithSum_K();
        int maxLen = longestSubarrayWithSum_K_obj1.longestSubarrayWithSumK(nums, k);
        System.out.println("Longest subarray length with sum " + k + ": " + maxLen);
    }
}
