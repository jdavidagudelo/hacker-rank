package com.jdavidagudelo.grid_challenge;

import java.util.Arrays;

public class GridChallenge {
    public String getAlphabetical(String[] grid){
        char[][] sorted = new char[grid.length][grid[0].length()];
        for(int i = 0; i < grid.length; i++){
            char[] c = grid[i].toCharArray();
            Arrays.sort(c);
            sorted[i] = c;
        }
        for(int i = 0; i < grid[0].length(); i++){
            for(int j = 1; j < grid.length; j++){
                if (sorted[j][i] < sorted[j - 1][i]) {
                    return "NO";
                }
            }
        }
        return "YES";
    }
    public static void main(String[] args){
        GridChallenge obj = new GridChallenge();
        System.out.println(obj.getAlphabetical(new String[]{
                "ebacd",
                "fghij",
                "olmkn",
                "trpqs",
                "xywuv"
        }));
    }
}
