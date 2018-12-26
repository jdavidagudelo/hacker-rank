package com.jdavidagudelo.and_max_triplets;

import java.util.Arrays;

public class AndMaxTriplets {
    private long maxAndTriplet(int[] a){
        boolean[] f = new boolean[a.length];
        Arrays.fill(f, true);
        int[][] bits = new int[a.length][33];
        for(int i = 0; i < a.length; i++){
            int j = 32;
            int num = a[i];
            while(num != 0){
                if ((num & 1) != 0) {
                    bits[i][j] = 1;
                }

                j--;

                // Dividing number by 2.
                num >>= 1;
            }
        }
        long ans = 0;
        for (int i = 0; i <= 32; ++i) {
            int cnt = 0;

            for (int j = 0; j < a.length; ++j) {
                if (bits[j][i] != 0 && f[j]) {
                    cnt++;
                }
            }

            // If cnt greater than 3 then (32-i)th bits
            // of the number will be set.
            if (cnt >= 3) {

                ans += Math.pow(2L, 32 - i);

                // Setting flags of the numbers
                // whose ith bit is not set.
                for (int j = 0; j < a.length; ++j) {
                    if (bits[j][i] == 0) {
                        f[j] = false;
                    }
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < a.length; ++i) {
            if (f[i]) {
                cnt++;
            }
        }

        return (cnt * (cnt - 1) * (cnt - 2)) / 6;
    }
    public static void main(String[] args)
    {
        int[] a = { 4, 11, 10, 15, 26 };
        AndMaxTriplets obj = new AndMaxTriplets();
        long result = obj.maxAndTriplet(a);
        System.out.println(result);
    }
}
