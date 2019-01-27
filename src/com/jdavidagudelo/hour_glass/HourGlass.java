package com.jdavidagudelo.hour_glass;

public class HourGlass {

    public int getValue(int[][] data){
        int max = Integer.MIN_VALUE;
        int[][] deltas = new int[][]{
                {0, 0},
                {0, 1},
                {0, 2},
                {1, 1},
                {2, 0},
                {2, 1},
                {2, 2}
        };
        for(int i = 0; i + 2 < data.length; i++){
            for(int j = 0; j + 2 < data.length; j++){
                int sum = 0;
                for(int[] di: deltas){
                    sum += data[i + di[0]][j + di[1]];
                }
                max = Math.max(sum, max);
            }
        }
        return max;
    }

    public static void main(String[] args){

    }
}
