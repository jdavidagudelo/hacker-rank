package com.jdavidagudelo.short_palindrome;

public class ShortPalindrome {

    private long mod = (long)1e9 + 7;
    public long getNumberOfTuples(String s){
        long[][][] dp = new long[26][26][4];
        for(int k = 0; k < s.length(); k++){
            int i = s.charAt(k) - 'a';
            for(int j = 0; j < 26; j++){
                dp[i][j][3] = (dp[i][j][3] + dp[i][j][2]) % mod;
                dp[j][i][2] = (dp[j][i][2] + dp[j][i][1]) % mod;
                dp[j][i][1] = (dp[j][i][1] + dp[j][i][0]) % mod;
                dp[i][j][0] = (dp[i][j][0] + 1) % mod;
            }
        }
        long result = 0;
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                result = (result + dp[i][j][3]) % mod;
            }
        }
        return result;
    }

    public static void main(String[] args){
        ShortPalindrome obj = new ShortPalindrome();
        System.out.println(obj.getNumberOfTuples("kkkkkkz"));
    }
}
