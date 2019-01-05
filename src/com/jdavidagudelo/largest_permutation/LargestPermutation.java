package com.jdavidagudelo.largest_permutation;

import java.util.*;

public class LargestPermutation {

    public Integer[] getLargestPermutation(Integer[] data, int k){
        int[] pos = new int[data.length + 1];
        for (int i = 0; i < data.length; ++i) {
            pos[data[i]] = i;
        }
        for (int i=0; i < data.length && k > 0; ++i)
        {
            // If element is already i'th largest,
            // then no need to swap
            if (data[i] == data.length - i) {
                continue;
            }

            // Find position of i'th largest value, n-i
            int temp = pos[data.length - i];

            // Swap the elements position
            pos[data[i]] = pos[data.length - i];
            pos[data.length - i] = i;
            int aux = data[temp];
            data[temp] = data[i];
            data[i] = aux;

            // decrement number of swaps
            --k;
        }
        return data;
    }
    public static void main(String[] args){
        LargestPermutation obj = new LargestPermutation();
        System.out.println(Arrays.toString(obj.getLargestPermutation(new Integer[]{4, 2, 3, 5, 1}, 1)));
        System.out.println(Arrays.toString(obj.getLargestPermutation(new Integer[]{4, 2, 3, 5, 1}, 2)));
        System.out.println(Arrays.toString(obj.getLargestPermutation(new Integer[]{2, 1, 3}, 1)));
        System.out.println(Arrays.toString(obj.getLargestPermutation(new Integer[]{2, 1}, 1)));
    }
}
