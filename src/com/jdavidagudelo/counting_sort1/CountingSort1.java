package com.jdavidagudelo.counting_sort1;

import java.util.Arrays;

public class CountingSort1 {
    public int[] countingSort(int[] data){
        int[] result = new int[100];
        for(int v: data){
            result[v] += 1;
        }
        return result;
    }
    public static void main(String[] args){
    }
}
