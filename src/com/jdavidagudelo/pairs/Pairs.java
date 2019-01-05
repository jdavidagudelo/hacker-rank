package com.jdavidagudelo.pairs;

import java.util.Arrays;

public class Pairs {
    public static int binarySearch(int[] data, int value){
        int start = 0;
        int end = data.length - 1;
        while(start <= end){
            int mid = (int)Math.floor((start + end) / 2.0);
            if(data[mid] < value){
                start = mid + 1;
            }
            else if(data[mid] > value){
                end = mid - 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    static int getPairs(int[] data, int k){
        Arrays.sort(data);
        int count = 0;
        for (int datum : data) {
            int j = datum + k;
            int search = binarySearch(data, j);
            if (search >= 0) {
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args){
        Pairs obj = new Pairs();
        System.out.println(obj.getPairs(new int[]{1, 5, 3, 4, 2}, 2));
    }
}
