package com.example.test.p1_leetCode;

import java.util.HashMap;

/*
Problem statement
You are given a string 'str' of lowercase alphabets and an integer 'k' .
Your task is to return the count all the possible substrings that have exactly 'k' distinct characters.

For example:
'str' = abcad and 'k' = 2.
We can see that the substrings {ab, bc, ca, ad} are the only substrings with 2 distinct characters.
Therefore, the answer will be 4.
 */


public class C7_SubstringWithKDistinctCharacters
{

    public int countSubstringsWithKDistinct(String str, int k)
    {
        int count = 0; //to store the count of substrings
        int left = 0; //left pointer of the sliding window
        int distinctCount = 0; //to count the number of distinct characters in the window
        HashMap<Character, Integer> charFrequency = new HashMap<>(); //to store the frequency of characters

        for (int rightIndex = 0; rightIndex <= str.length()-1; rightIndex++)
        {
            char rightChar = str.charAt(rightIndex);

            // Update frequency of right character
            charFrequency.put(rightChar, charFrequency.getOrDefault(rightChar, 0) + 1);

            // If a new distinct character is added, update distinctCount
            if (charFrequency.get(rightChar) == 1)
            {
                distinctCount= distinctCount+1;
            }

            // Adjust the window size
            while (distinctCount > k)
            {
                char leftChar = str.charAt(left);

                // Reduce frequency of left character
                charFrequency.put(leftChar, charFrequency.get(leftChar) - 1);

                // If left character's frequency becomes zero, reduce distinctCount
                if (charFrequency.get(leftChar) == 0)
                {
                    distinctCount--;
                }

                // Move the left pointer to shrink the window
                left =left +1;
            }

            // Count the substrings with exactly 'k' distinct characters
            count = count + (rightIndex - left + 1);
        }

        return count;
    }

    public static void main(String[] args)
    {
        String str = "abcad";
        int k = 2;
        C7_SubstringWithKDistinctCharacters c7_SubstringWithKDistinctCharacters_obj1 =
                new C7_SubstringWithKDistinctCharacters();

        System.out.println(c7_SubstringWithKDistinctCharacters_obj1.countSubstringsWithKDistinct(str, k)); // Output: 4
    }
}
