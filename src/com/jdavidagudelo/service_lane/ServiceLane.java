package com.jdavidagudelo.service_lane;

import java.util.Arrays;

public class ServiceLane {
    public int[] getServiceLane(int[][] cases, int[] width){
        int[] result = new int[cases.length];
        for(int i = 0; i < cases.length; i++){
            int start = cases[i][0];
            int end = cases[i][1];
            int min = Integer.MAX_VALUE;
            for(int k = start; k <= end; k++){
                min = Math.min(min, width[k]);
            }
            result[i] = min;
        }
        return result;
    }
    public static void main(String[] args){
        int[] width = {2, 3, 1, 2, 3, 2, 3, 3};
        int[][] cases = {{0, 3}, {4, 6}, {6, 7}, {3, 5}, {0, 7}};
        ServiceLane obj = new ServiceLane();
        int[] result = obj.getServiceLane(cases, width);
        System.out.println(Arrays.toString(result));
    }
}
