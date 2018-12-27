package com.jdavidagudelo.closest_numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestNumbers {
    public int[] getMinimumPairs(int[] data){
        Arrays.sort(data);
        int min = Integer.MAX_VALUE;
        List<Integer[]> pairs = new ArrayList<>();
        for(int i = 0; i < data.length - 1; i++){
            int diff = Math.abs(data[i] - data[i+1]);
            if(diff == min) {
                pairs.add(new Integer[]{data[i], data[i + 1]});
            }
            else if(diff < min){
                pairs = new ArrayList<>();
                pairs.add(new Integer[]{data[i], data[i + 1]});
                min = diff;
            }
        }
        int[] result = new int[pairs.size() * 2];
        int k = 0;
        for(Integer[] x: pairs){
            result[k] = x[0];
            result[k + 1] = x[1];
            k += 2;
        }
        return result;
    }
    public static void main(String[] args){
        int[] data = new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854};
        ClosestNumbers obj = new ClosestNumbers();
        int[] result = obj.getMinimumPairs(data);
        System.out.println(Arrays.toString(result));
        int[] other = new int[]{-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470 };
        result = obj.getMinimumPairs(other);
        System.out.println(Arrays.toString(result));

    }
}
