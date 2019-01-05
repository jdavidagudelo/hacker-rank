package com.jdavidagudelo.minimum_loss;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MinimumLoss {

    long getMinimumLoss(long[] data){
        Map<Long, Long> map = new HashMap<>();
        for(Long i = 0L; i < data.length; i++){
             map.put(data[i.intValue()], i);
        }
        Arrays.sort(data);
        long min = Long.MAX_VALUE;
        for(int i = 1; i < data.length; i++){
            Long currentIndex = map.get(data[i]);
            Long previousIndex = map.get(data[i - 1]);
            if(currentIndex < previousIndex) {
                min = Math.min(data[i] - data[i - 1], min);
            }
        }
        return min;
    }

    public static void main(String[] args){
        MinimumLoss obj = new MinimumLoss();
        System.out.println(obj.getMinimumLoss(new long[]{5, 10, 3}));
        System.out.println(obj.getMinimumLoss(new long[]{20, 7, 8, 2, 5}));
    }
}
