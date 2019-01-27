package com.jdavidagudelo.power_sum;

public class PowerSum {

    public static int countWays(int n, int i, int v, int value){
        if(v + (int)Math.pow(i, n) == value){
            return 1 + countWays(n, i + 1, v, value);
        }
        int sqrt = (int)Math.sqrt(value);
        if(v > value || i > sqrt){
            return 0;
        }
        return countWays(n, i + 1, v + (int)Math.pow(i, n), value) + countWays(n, i + 1, v, value);
    }

    public static void main(String[] args){
        System.out.println(PowerSum.countWays(2, 1, 0, 10));
        System.out.println(PowerSum.countWays(2, 1, 0, 100));
    }
}
