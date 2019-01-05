package com.jdavidagudelo.min_max;

import java.util.Arrays;

public class MinMax {
    public int getMinMax(int[] data, int k){
        Arrays.sort(data);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i + k <= data.length; i++){
            min = Math.min(data[i + k - 1] - data[i], min);
        }
        return min;
    }
    public static void main(String[] args){
        MinMax obj = new MinMax();
        System.out.println(obj.getMinMax(new int[]{100,
                200,
                300,
                350,
                400,
                401,
                402}, 3));
    }
}
