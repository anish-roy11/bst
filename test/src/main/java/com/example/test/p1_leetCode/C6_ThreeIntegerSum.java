package com.example.test.p1_leetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class C6_ThreeIntegerSum
{




    public C6_ThreeIntegerSum()
    {

    }


    public boolean doesTripletsExists( int[] array)
    {
        int arraySize = array.length;
        Arrays.sort(array);

        for (int i = 0; i <= arraySize - 1; i++)
        {
            int left = i + 1;
            int right = arraySize - 1;

            while (left < right)
            {
                int sum = array[i] + array[left] + array[right];

                if (sum == 0)
                {
                    //System.out.println("Triplets found:" + array[i] + ", " + array[left] + ", " + array[right]);
                    System.out.println("Triplets found:");
                    return true; // Return true if triplets are found
                } else if (sum < 0)
                {
                    left++;
                } else
                {
                    right--;
                }
            }
        }

        return false; // Return false if no triplets are found
    }


    public Set<Set<Integer>> findAllTriplets(int[] array)
    {
        int arraySize = array.length;

        Arrays.sort(array);
        Set<Set<Integer>> setsOfThreeSets = new HashSet<>();

        for (int i = 0; i <= arraySize - 1; i++)
        {
            int leftPointer = i + 1;
            int rightPointer = arraySize - 1;

            while (leftPointer < rightPointer)
            {
                int sum = array[i] + array[leftPointer] + array[rightPointer];

                if (sum == 0)
                {
                    System.out.println("Triplets found== " + array[i] + ", " + array[leftPointer] + ", " + array[rightPointer]);

                    Set<Integer> setsOfThreeNumbers = new HashSet<>();
                    setsOfThreeNumbers.add(array[i]);
                    setsOfThreeNumbers.add(array[leftPointer]);
                    setsOfThreeNumbers.add(array[rightPointer]);

                    setsOfThreeSets.add(setsOfThreeNumbers);

                    leftPointer = leftPointer + 1;
                    rightPointer = rightPointer - 1;


                }
                else if (sum < 0)
                {
                    leftPointer = leftPointer + 1;
                }
                else
                {
                    rightPointer = rightPointer - 1;
                }
            }
        }
        if(setsOfThreeSets.size() > 0)
        {
            return setsOfThreeSets;
        }
        else
        {
            return null;
        }


    }

    public static void main(String[] args)
    {

        int[] array = {1, -2, 0, 5, -1, -4, 2};

        C6_ThreeIntegerSum c6_ThreeIntegerSum_Obj1 = new C6_ThreeIntegerSum();

        boolean result = c6_ThreeIntegerSum_Obj1.doesTripletsExists(array);
        if (!result)
        {
            System.out.println("No triplets found.");
        }


        Set<Set<Integer>> setsOfThreeSets = new HashSet<>();
        setsOfThreeSets = c6_ThreeIntegerSum_Obj1.findAllTriplets(array);
        System.out.print("\n tripletsSet.Size="+setsOfThreeSets.size());



    }
}
