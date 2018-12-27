package com.jdavidagudelo.find_median;

import java.util.Arrays;

public class FindMedian {
    public int getMedian(int[] data){
        Arrays.sort(data);
        return data[data.length / 2];
    }
    public static void main(String[] args){
        FindMedian obj = new FindMedian();
        int[] data = new int[]{0, 1, 2, 4, 6, 5, 3};
        int result = obj.getMedian(data);
        System.out.println(result);
    }
}
