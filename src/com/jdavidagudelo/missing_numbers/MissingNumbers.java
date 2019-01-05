package com.jdavidagudelo.missing_numbers;

import java.util.*;

public class MissingNumbers {
    public int[] getMissingNumbers(int[] original, int[] missing){
        Map<Integer, Integer> counts = new HashMap<>();
        for(int oi: original) {
            Integer current = counts.get(oi);
            if(current == null){
                current = 0;
            }
            counts.put(oi, current + 1);
        }
        TreeSet<Integer> result = new TreeSet<>();
        Map<Integer, Integer> missingCounts = new HashMap<>();
        for(int mi: missing){
            Integer current = missingCounts.get(mi);
            if(current == null){
                current = 0;
            }
            missingCounts.put(mi, current + 1);
        }
        for(int value: counts.keySet()){
            if(!counts.get(value).equals(missingCounts.get(value))){
                result.add(value);
            }
        }
        int[] values = new int[result.size()];
        int k = 0;
        for(int v: result){
            values[k] = v;
            k += 1;
        }
        return values;
    }
    public static void main(String[] args){
        MissingNumbers obj = new MissingNumbers();
        System.out.println(Arrays.toString(obj.getMissingNumbers(
                new int[] {203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204},
                new int[]{203, 204, 205, 206, 207, 208, 203, 204, 205, 206})));
    }
}
