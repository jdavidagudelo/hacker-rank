package com.jdavidagudelo.mark_and_toys;

import java.util.Arrays;

public class MarkAndToys {
    public int maximumToys(int[] prices, int k){
        Arrays.sort(prices);
        int count = 0;
        for(int i = 0; i < prices.length; i++){
            if(k >= prices[i]){
                count++;
                k -= prices[i];
            }
        }
        return count;
    }
    public static void main(String[] args){
        MarkAndToys obj = new MarkAndToys();
        System.out.println(obj.maximumToys(new int[]{1, 12, 5, 111, 200, 1000, 10}, 50));
    }
}
