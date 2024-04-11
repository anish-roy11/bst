package com.example.test.p1_leetCode;

import java.util.HashMap;
import java.util.Map;

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

Time complexity is O(n)
 */

public class C1_z1_LongestSubstringWithoutRepeatingCharacters
{

    public int getLongestSubstringWithoutRepeatingCharacters(String str)
    {
        Map<Character, Integer> characterMap1 = new HashMap<Character, Integer>();
        int left=0;
        int right=0;
        int n=str.length();
        int length=0;
        while(right <= (n-1))
        {
            char character=str.charAt(right);
            // if characterMap1 contains characterat position p
            //move left to the position after p
            if(characterMap1.containsKey(character))
            {
                left=Math.max( (characterMap1.get(character) + 1) , left);
            }
            characterMap1.put(character, right); //put index of character in characterMap1
            length=Math.max(length, (right-left+1) );
            right=right+1;
        }

        return length;
    }

    public static void main(String args[])
    {
        C1_z1_LongestSubstringWithoutRepeatingCharacters c1_z1_LongestSubstringWithoutRepeatingCharacters =
                new C1_z1_LongestSubstringWithoutRepeatingCharacters();

        int longestSubstringCount =
                c1_z1_LongestSubstringWithoutRepeatingCharacters.getLongestSubstringWithoutRepeatingCharacters("abcdedfrgt");

        System.out.println("longestSubstringCount=" + longestSubstringCount);




    }
}
