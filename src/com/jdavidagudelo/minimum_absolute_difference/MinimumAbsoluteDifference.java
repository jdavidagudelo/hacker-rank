package com.jdavidagudelo.minimum_absolute_difference;

import com.jdavidagudelo.minimum_distances.MinimumDistances;

import java.util.Arrays;

public class MinimumAbsoluteDifference {
    public int getMinimum(int[] data){
        Arrays.sort(data);
        int min = Integer.MAX_VALUE;
        for(int i = 1; i < data.length; i++){
            min = Math.min(Math.abs(data[i - 1] - data[i]), min);
        }
        return min;
    }
    public static void main(String[] args){
        MinimumAbsoluteDifference obj = new MinimumAbsoluteDifference();
        System.out.println(obj.getMinimum(new int[]{-59, -36, -13, 1, -53, -92, -2, -96, -54, 75}));
        System.out.println(obj.getMinimum(new int[]{1, -3, 71, 68, 17}));
    }
}
