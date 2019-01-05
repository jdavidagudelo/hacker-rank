package com.jdavidagudelo.mark_cake_walk;

import java.util.Arrays;

public class MarkCakeWalk {

    public long getMinDistance(int[] data){
        Arrays.sort(data);
        long result = 0;
        for(int i = data.length - 1; i >= 0; i--){
            result += Math.pow(2, data.length - i - 1) * data[i];
        }
        return result;
    }

    public static void main(String[] args){
        MarkCakeWalk obj = new MarkCakeWalk();
        System.out.println(obj.getMinDistance(new int[]{1, 3, 2}));
        System.out.println(obj.getMinDistance(new int[]{7, 4, 9, 6}));
    }
}
