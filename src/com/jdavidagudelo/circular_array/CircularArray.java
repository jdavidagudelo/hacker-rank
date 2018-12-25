package com.jdavidagudelo.circular_array;

import java.util.Arrays;

public class CircularArray {

    public int getIndex(int k, int n){
        while(k < 0) {
            k += n;
        }
        return k % n;
    }
    public Integer[] getCircularArray(Integer[] data, Integer[] queries, int k) {
        Integer[] newArray = new Integer[data.length];
        for(int i = 0; i < data.length; i++) {
            newArray[i] = data[this.getIndex(i - k + data.length, data.length)];
        }
        Integer[] result = new Integer[queries.length];
        for(int i = 0; i < queries.length; i++){
            result[i] = newArray[queries[i]];
        }
        return result;
    }
    public static void main(String[] args){
        CircularArray obj = new CircularArray();
        Integer[] data = {1, 2, 3};
        Integer[] queries = {0, 1, 2};
        Integer[] result = obj.getCircularArray(data, queries, 2);
        System.out.println(Arrays.toString(result));
    }
}
