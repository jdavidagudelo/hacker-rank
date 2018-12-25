package com.jdavidagudelo.non_divisible_subset;

import java.util.Arrays;

public class NonDivisibleSubset {
    private int nonDivisibleSubset(Integer[] values, int k){
        int[] f = new int[k];
        Arrays.fill(f, 0);

        // Fill frequency array with values modulo K
        for (Integer value : values) {
            f[value % k]++;
        }

        // if K is even, then update f[K/2]
        if (k % 2 == 0) {
            f[k / 2] = Math.min(f[k / 2], 1);
        }

        // Initialize result by minimum of 1 or
        // count of numbers giving remainder 0
        int res = Math.min(f[0], 1);

        // Choose maximum of count of numbers
        // giving remainder i or K-i
        for (int i = 1; i <= k / 2; i++) {
            res += Math.max(f[i], f[k - i]);
        }
        return res;
    }
    public static void main(String[] args){
        Integer[] data = {1, 7, 2, 4};
        int k = 3;
        NonDivisibleSubset obj = new NonDivisibleSubset();
        System.out.println(obj.nonDivisibleSubset(data, k));
    }
}
