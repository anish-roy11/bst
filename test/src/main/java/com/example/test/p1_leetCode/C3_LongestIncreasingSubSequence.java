package com.example.test.p1_leetCode;

/*

300. Longest Increasing Subsequence
Medium

Given an integer array nums, return the length of the longest strictly increasing
subsequence
.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104


Follow up: Can you come up with an algorithm that runs in O(n log(n)) time complexity?
 */


import java.util.Arrays;

public class C3_LongestIncreasingSubSequence {

    public int lengthOfLongestIncreasingSubSequence(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        int maxLength = 1;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        C3_LongestIncreasingSubSequence c3_LongestIncreasingSubSequenceObj1=new C3_LongestIncreasingSubSequence();

        int result = c3_LongestIncreasingSubSequenceObj1.lengthOfLongestIncreasingSubSequence(nums);
        System.out.println("Length of the longest strictly increasing subsequence: " + result);
    }
}
