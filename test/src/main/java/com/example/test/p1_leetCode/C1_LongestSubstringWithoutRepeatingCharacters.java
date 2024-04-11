package com.example.test.p1_leetCode;

/*
3. Longest Substring Without Repeating Characters
Medium

Companies
Given a string s, find the length of the longest
substring
 without repeating characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */

public class C1_LongestSubstringWithoutRepeatingCharacters
{


    public int lengthOfLongestSubstring(String str)
    {
        int n = str.length();
        int ans = 0;
        int[] lastSeen = new int[128]; // Assuming ASCII characters

        for (int i = 0; i < lastSeen.length; i++)
        {
            lastSeen[i] = -1;
        }

        int leftIndex = 0;
        for (int rightIndex = 0; rightIndex < n; rightIndex++)
        {
            int index = str.charAt(rightIndex);
            leftIndex = Math.max(leftIndex, lastSeen[index] + 1);
            ans = Math.max(ans, rightIndex - leftIndex + 1);
            lastSeen[index] = rightIndex;
        }

        return ans;
    }

    public static void main(String args[])
    {
        C1_LongestSubstringWithoutRepeatingCharacters c1_LongestSubstringWithoutRepeatingCharactersObj1 = new C1_LongestSubstringWithoutRepeatingCharacters();

        int longestSubstringCount = c1_LongestSubstringWithoutRepeatingCharactersObj1.lengthOfLongestSubstring("abcdedfrgt");
        System.out.println("longestSubstringCount=" + longestSubstringCount);

        int longestSubstringCount2 = c1_LongestSubstringWithoutRepeatingCharactersObj1.lengthOfLongestSubstring("pwwkew");
        System.out.println("longestSubstringCount2=" + longestSubstringCount2);

        int longestSubstringCount3 = c1_LongestSubstringWithoutRepeatingCharactersObj1.lengthOfLongestSubstring("dvdf");
        System.out.println("longestSubstringCount3=" + longestSubstringCount3);


    }
}
