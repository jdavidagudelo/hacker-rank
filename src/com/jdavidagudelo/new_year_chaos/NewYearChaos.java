package com.jdavidagudelo.new_year_chaos;

public class NewYearChaos {

    public static String solve(int[] data){
        int ans = 0;
        for (int i = data.length - 1; i >= 0; i--) {
            if (data[i] - (i + 1) > 2) {
                return "Too chaotic";
            }
            for (int j = Math.max(0, data[i] - 2); j < i; j++) {
                if (data[j] > data[i]) {
                    ans++;
                }
            }
        }
        return "" + ans;
    }

    public static void main(String[] args){
        System.out.println(NewYearChaos.solve(new int[]{2, 1, 5, 3, 4}));
        System.out.println(NewYearChaos.solve(new int[]{2, 5, 1, 3, 4}));
    }
}
