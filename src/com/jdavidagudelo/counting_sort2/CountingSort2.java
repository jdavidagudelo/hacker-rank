package com.jdavidagudelo.counting_sort2;

public class CountingSort2 {
    public int[] countingSort(int[] data){
        int[] result = new int[100];
        for(int v: data){
            result[v] += 1;
        }
        int[] ordered = new int[data.length];
        int k = 0;
        for(int i = 0; i < result.length; i++){
            for(int d = 0; d < result[i]; d++){
                ordered[k + d] = i;
            }
            k += result[i];
        }
        return ordered;
    }
    public static void main(String[] args){
    }
}
