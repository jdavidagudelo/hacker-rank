package com.jdavidagudelo.substring_diff;

public class SubStringDiff {

    private static Integer[][][] dp;

    public static int lcSuffix(char[] x, char[] y, int m, int n, int k){
        if(m <= 0 || n <= 0){
            return 0;
        }
        if(dp[m][n][k] != null){
            return dp[m][n][k];
        }
        if(x[m - 1] == y[n - 1]){
            return dp[m][n][k] = 1 + lcSuffix(x, y, m - 1, n - 1, k);
        }
        else if(k > 0){
            return dp[m][n][k] = 1 + lcSuffix(x, y, m - 1, n - 1, k - 1);
        }
        return dp[m][n][k] = 0;
    }
    public static int lcSubString(char[] x, char[] y, int m, int n, int k){
        int max = 0;
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                max = Math.max(max, lcSuffix(x, y, i, j, k));
            }
        }
        return max;
    }

    public static int solve(String s1, String s2, int k){
        char[] x = s1.toCharArray();
        char[] y = s2.toCharArray();
        dp = new Integer[x.length + 1][y.length + 1][k + 1];
        return lcSubString(x, y, x.length, y.length, k);

    }

    public static void main(String[] args){
        System.out.println(SubStringDiff.solve("tabriz", "torino", 2));
        System.out.println(SubStringDiff.solve("abacba", "abcaba", 0));
        System.out.println(SubStringDiff.solve("helloworld", "yellomarin", 3));
    }

}
