package com.jdavidagudelo.container_balls;

import java.util.Arrays;

public class ContainerBalls {
    public String getContainerBalls(int[][] container){
        int n = container.length;
        long[] types = new long[n];
        long[] containersCapacity = new long[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                containersCapacity[i] += container[i][j];
                types[j] += container[i][j];
            }
        }
        Arrays.sort(types);
        Arrays.sort(containersCapacity);
        if(!Arrays.equals(types, containersCapacity)){
            return "Impossible";
        }
        return "Possible";
    }
    public static void main(String[] args){
        ContainerBalls obj = new ContainerBalls();
        System.out.println(obj.getContainerBalls(new int[][]{{1, 1},
                {1, 1}}));
        System.out.println(obj.getContainerBalls(new int[][]{{0, 2},
                {1, 1}}));
        System.out.println(obj.getContainerBalls(new int[][]{{0, 2, 1},
                {1, 1, 1},
                {2, 0, 0}}));
        System.out.println(obj.getContainerBalls(new int[][]{{1, 3, 1},
                {2, 1, 2},
                {3, 3, 3}}));

        System.out.println(obj.getContainerBalls(new int[][]{{999336263, 998799923},
                {998799923, 999763019}}));

        System.out.println(obj.getContainerBalls(new int[][]{
                {997612619, 934920795, 998879231, 999926463},
                {960369681, 997828120, 999792735, 979622676},
                {999013654, 998634077, 997988323, 958769423},
                {997409523, 999301350, 940952923, 993020546}
        }));
    }
}
