package com.jdavidagudelo.minimum_distances;

public class MinimumDistances {

    public int getMinimumDistance(int[] a){
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < a.length; i++){
            int currentValue = a[i];
            for(int j = i + 1; j < a.length; j++){
                if(currentValue == a[j]){
                    minDistance = Math.min(minDistance, j - i);
                }
            }
        }
        if(minDistance == Integer.MAX_VALUE){
            return -1;
        }
        return minDistance;
    }

    public static void main(String[] args){
        int[] data = {7, 1, 3, 4, 1, 7};
        MinimumDistances obj = new MinimumDistances();
        int result = obj.getMinimumDistance(data);
        System.out.println(result);
    }
}
