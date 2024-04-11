package com.example.test.p1_leetCode;

/*
Length of Largest Subarray with Contiguous Elements

For example:
array = [9, 2, 7, 5, 6, 23, 24, 22, 23, 19, 17, 16, 18, 39, 0,5]
contiguous elements here are:
23, 24, 22
24, 22, 23
19, 17, 16, 18

 */

import java.util.HashSet;
import java.util.Iterator;

public class C8_LargestSubarrayWithContiguousElements
{

    public void findLargestSubarrayWithContiguousElements(int[] array)
    {

        int answer=0;
        int n = array.length; // array is from 0 to n-1
        HashSet<Integer> uniqueValuesSet = new HashSet<>();

        for(int i=0; i <= (n-2); i++ ) //i from 0 to n-2
        {
            int minimum=array[i];
            int maximum=array[i];
            uniqueValuesSet = new HashSet<>();
            uniqueValuesSet.add(array[i]);

            for(int j=i+1; j <= n-1; j++ ) //j from i+1 to n-1
            {
                if(uniqueValuesSet.contains(array[j]))
                {
                    break;
                }
                uniqueValuesSet.add(array[j]);

                System.out.print("\n uniqueValuesSet Elements=");
                for( Iterator<Integer> iterator = uniqueValuesSet.iterator(); iterator.hasNext() ; )
                {
                    int a=iterator.next();
                    System.out.print("\n "+ a+ " ");

                }

                minimum = Math.min(minimum, array[j]);
                maximum = Math.max(maximum, array[j]);

                //for contiguous numbers, (maximum - minimum) == (j - i)
                if((maximum - minimum) == (j - i))
                {
                    int length = j - i + 1;
                    if(length > answer)
                    {
                        answer =length;
                    }
                }

            }
        }

        System.out.print("\n Length of Largest Subarray With Contiguous Elements="+answer);
//        for( Iterator<Integer> iterator = uniqueValuesSet.iterator(); iterator.hasNext() ; )
//        {
//            int a=iterator.next();
//            System.out.print("\n "+ a+ " ");
//
//        }
    }

    public static void main(String args[])
    {

        int[] array = {9, 2, 7, 5, 6, 23, 24, 22, 23, 19, 17, 16, 18, 39, 0,5, 3,4,2,1};
        C8_LargestSubarrayWithContiguousElements c8_LargestSubarrayWithContiguousElements_obj1
                = new C8_LargestSubarrayWithContiguousElements();

        c8_LargestSubarrayWithContiguousElements_obj1.findLargestSubarrayWithContiguousElements(array);


    }
}
