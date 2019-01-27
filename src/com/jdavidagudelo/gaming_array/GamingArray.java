package com.jdavidagudelo.gaming_array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GamingArray {

    public static String getWinner(int[] data){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < data.length; i++){
            map.put(data[i], i);
        }
        int count = 0;
        int endIndex = data.length - 1;
        Arrays.sort(data);
        for(int i = data.length - 1; i >= 0; i--){
            int index = map.get(data[i]);
            if(index <= endIndex){
                endIndex = index - 1;
                count += 1;
            }
        }
        return count % 2 == 0? "ANDY": "BOB";
    }

    public static String solve(List<Integer> data){
        int[] x = new int[data.size()];
        for(int i = 0; i < data.size(); i++){
            x[i] = data.get(i);
        }
        return getWinner(x);
    }

    public static void main(String[] args){
        System.out.println(GamingArray.getWinner(new int[]{5, 2, 6, 3, 4}));
        System.out.println(GamingArray.getWinner(new int[]{3, 1}));
    }
}
