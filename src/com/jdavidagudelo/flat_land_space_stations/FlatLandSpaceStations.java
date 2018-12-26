package com.jdavidagudelo.flat_land_space_stations;

public class FlatLandSpaceStations {
    public int getMinDistance(int index, int[] c){
        int minDistance = Integer.MAX_VALUE;
        for(int i = 0; i < c.length; i++){
            minDistance = Math.min(minDistance, Math.abs(c[i] - index));
        }
        return minDistance;
    }
    public int getMaximumDistance(int n, int[] c){
        int maxDistance = 0;
        for(int i = 0; i < n; i++){
            maxDistance = Math.max(maxDistance, this.getMinDistance(i, c));
        }
        return maxDistance;
    }
    public static void main(String[] args){
        FlatLandSpaceStations obj  = new FlatLandSpaceStations();
        int n = 5;
        int[] c = {0, 4};
        int result = obj.getMaximumDistance(n, c);
        System.out.println(result);
    }
}
