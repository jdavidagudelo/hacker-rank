package com.jdavidagudelo.left_rotation;

import java.util.Arrays;

public class LeftRotation {

    int[] getResult(int[] data, int d){
        int[] result = new int[data.length];
        for(int k = 0; k < data.length; k++){
            result[k] = data[(k + d) % data.length];
        }
        return result;
    }

    public static void main(String[] args){
        LeftRotation obj = new LeftRotation();
        System.out.println(Arrays.toString(obj.getResult(new int[]{1, 2, 3, 4, 5}, 4)));
    }
}
