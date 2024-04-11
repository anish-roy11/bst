package com.example.test.p1_leetCode;

/*
673. Number of Longest Increasing Subsequence
Medium

Given an integer array nums, return the number of longest increasing subsequences.

Notice that the sequence has to be strictly increasing.



Example 1:

Input: nums = [1,3,5,4,7]
Output: 2
Explanation: The two longest increasing subsequences are [1, 3, 4, 7] and [1, 3, 5, 7].
Example 2:

Input: nums = [2,2,2,2,2]
Output: 5
Explanation: The length of the longest increasing subsequence is 1, and there are 5 increasing subsequences of length 1, so output 5.


Constraints:

1 <= nums.length <= 2000
-106 <= nums[i] <= 106


To find the number of longest increasing subsequences, you can use a combination of dynamic programming and a separate count array.
In this implementation:

We use two arrays, lengths to store the length of the longest increasing subsequence ending at each position and
counts to store the number of such subsequences.
We iterate through the input array nums and update the lengths and counts arrays accordingly.
The variable maxLength keeps track of the length of the longest increasing subsequence.
We then iterate through the lengths array to count the number of subsequences with length equal to maxLength.
This algorithm has a time complexity of O(n^2), where n is the length of the input array.

 */

import java.util.Arrays;

public class C4_NumberOfLongestIncreasingSubsequence {

    public int findNumberOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] lengths = new int[n];
        int[] counts = new int[n];

        Arrays.fill(lengths, 1);
        Arrays.fill(counts, 1);

        int maxLength = 1;
        int result = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    if (lengths[j] + 1 > lengths[i]) {
                        lengths[i] = lengths[j] + 1;
                        counts[i] = counts[j];
                    } else if (lengths[j] + 1 == lengths[i]) {
                        counts[i] += counts[j];
                    }
                }
            }

            maxLength = Math.max(maxLength, lengths[i]);
        }

        for (int i = 0; i < n; i++) {
            if (lengths[i] == maxLength) {
                result += counts[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 4, 7};
        C4_NumberOfLongestIncreasingSubsequence c4_NumberOfLongestIncreasingSubsequenceObj1=new C4_NumberOfLongestIncreasingSubsequence();
        int result1 = c4_NumberOfLongestIncreasingSubsequenceObj1.findNumberOfLIS(nums1);
        System.out.println("Number of longest increasing subsequences: " + result1);

        int[] nums2 = {2, 2, 2, 2, 2};
        int result2 = c4_NumberOfLongestIncreasingSubsequenceObj1.findNumberOfLIS(nums2);
        System.out.println("Number of longest increasing subsequences: " + result2);
    }
}
