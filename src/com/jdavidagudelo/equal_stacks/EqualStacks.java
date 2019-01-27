package com.jdavidagudelo.equal_stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;

public class EqualStacks {

    static class ReversedOrder implements Comparable<ReversedOrder>{
        int x;

        ReversedOrder(int i){
            x = i;
        }

        @Override
        public int compareTo(ReversedOrder reversedOrder) {
            return Integer.compare(reversedOrder.x, x);
        }
    }

    public static int equalStacks(int[] h1, int[] h2, int[] h3) {
        TreeSet<ReversedOrder> s1 = new TreeSet<>();
        TreeSet<ReversedOrder> s2 = new TreeSet<>();
        TreeSet<ReversedOrder> s3 = new TreeSet<>();
        int sum = 0;

        for (int i = h1.length - 1; i >= 0; i--) {
            s1.add(new ReversedOrder(sum + h1[i]));
            sum += h1[i];
        }
        sum = 0;
        for (int i = h2.length - 1; i >= 0; i--) {
            s2.add(new ReversedOrder(sum + h2[i]));
            sum += h2[i];
        }
        sum = 0;
        for (int i = h3.length - 1; i >= 0; i--) {
            s3.add(new ReversedOrder(sum + h3[i]));
            sum += h3[i];
        }
        for(ReversedOrder v: s1){
            if(s2.contains(v) && s3.contains(v)){
                return v.x;
            }
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(EqualStacks.equalStacks(new int[]{3, 2, 1, 1, 1}, new int[]{4, 3, 2}, new int[]{1, 1, 4, 1}));
    }
}
