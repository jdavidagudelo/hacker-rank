package com.jdavidagudelo.sorted_arithmetic_progression_triplets;

// Java program to print all
// triplets in given array
// that form Arithmetic
// Progression
import java.util.*;

class SortedArithmeticProgressionTriplets
{
    // Function to print
    // all triplets in
    // given sorted array
    // that forms AP
    private static void printAllAPTriplets(int[] arr,
                                           int n)
    {
        ArrayList<Integer> s =
                new ArrayList<Integer>();
        for (int i = 0;
             i < n - 1; i++)
        {
            for (int j = i + 1; j < n; j++)
            {
                // Use hash to find if
                // there is a previous
                // element with difference
                // equal to arr[j] - arr[i]
                int diff = arr[j] - arr[i];
                boolean exists =
                        s.contains(arr[i] - diff);

                if (exists)
                    System.out.println(arr[i] - diff +
                            " " + arr[i] +
                            " " + arr[j]);
            }

            s.add(arr[i]);
        }
    }

    // Driver code
    public static void main(String[] args)
    {
        int []arr = {2, 6, 9, 12, 17,
                22, 31, 32, 35, 42};
        int n = arr.length;
        printAllAPTriplets(arr, n);
    }
}

