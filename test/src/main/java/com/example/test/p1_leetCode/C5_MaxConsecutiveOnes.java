package com.example.test.p1_leetCode;

/*
Given a binary array nums and an integer k, return the maximum number of
consecutive 1's in the array if you can flip at most k 0's.



Example 1:

Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
Example 2:

Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.


Constraints:

1 <= nums.length <= 105
nums[i] is either 0 or 1.
0 <= k <= nums.length
 */
public class C5_MaxConsecutiveOnes
{
    public int longestOnes(int[] array, int k)
    {
        int maxConsecutiveOnes = 0;
        int leftEnd = 0;
        int zeroCount = 0;
        int n=array.length;

        for (int rightEnd = 0; rightEnd <= n-1; rightEnd++)
        {
            if (array[rightEnd] == 0)
            {
                zeroCount = zeroCount + 1;
            }

            while (zeroCount > k)
            {
                if (array[leftEnd] == 0)
                {
                    zeroCount = zeroCount - 1;
                }
                leftEnd = leftEnd + 1;
            } //while loop ends

            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, rightEnd - leftEnd + 1);
        } //for loop ends

        return maxConsecutiveOnes;
    }

    public static void main(String[] args)
    {
        C5_MaxConsecutiveOnes c5_MaxConsecutiveOnes = new C5_MaxConsecutiveOnes();
        int[] nums = {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 1};
        int k = 2;
        System.out.println(c5_MaxConsecutiveOnes.longestOnes(nums, k)); // Output: 8
    }
}
