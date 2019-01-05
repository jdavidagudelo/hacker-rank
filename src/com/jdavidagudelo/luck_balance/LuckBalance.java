package com.jdavidagudelo.luck_balance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LuckBalance {
    public int luckBalance(int k, int[][] contests) {
        List<Integer> important = new ArrayList<>();
        List<Integer> unimportant = new ArrayList<>();
        int luck = 0;
        for(int[] ci: contests){
            luck += ci[0];
            if(ci[1] != 0){
                important.add(ci[0]);
            }
        }
        Collections.sort(important);
        for(int i = 0; i < important.size() - k && i < important.size(); i++){
            luck -= 2 * important.get(i);
        }
        return luck;
    }
    public static void main(String[] args){
        LuckBalance obj = new LuckBalance();
        System.out.println(obj.luckBalance(3, new int[][]{
                {5, 1},
                {2, 1},
                {1, 1},
                {8, 1},
                {10, 0},
                {5, 0}
        }));
    }
}
