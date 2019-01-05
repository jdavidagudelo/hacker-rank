package com.jdavidagudelo.maximum_palindromes;

import java.io.*;
import java.util.stream.IntStream;

class Result {
    private static int N = 100001;
    private static int A = 'z' - 'a' + 1;
    private static long[] fact = new long[N];
    private static long[] rFact = new long[N];
    private static int[][] cnt = new int[N][A];
    private static long mod = (long)1e9 + 7;
    /*
     * Complete the 'initialize' function below.
     *
     * The function accepts STRING s as parameter.
     */

    private static long power(long x, long y) {
        if (y == 0) {
            return 1;
        }
        if ((y & 1) > 0) {
            return power(x, y - 1) * x % mod;
        } else {
            long tmp = power(x, y / 2);
            return tmp * tmp % mod;
        }
    }

    private static long calc(int l, int r) {
        int sum = 0;
        int odd = 0;
        long res = 1;
        for (int i = 0; i < A; i++) {
            int cur = cnt[r][i] - cnt[l - 1][i];
            sum += cur / 2;
            res = res * rFact[cur / 2] % mod;
            if (cur % 2 == 1) {
                odd++;
            }
        }
        res = res * Math.max(1, odd) % mod;
        res = res * fact[sum] % mod;
        return res;
    }

    static void initialize(String s) {
        // This function is called once before all queries.
        cnt = new int[N][A];
        fact[0] = 1;
        rFact[0] = 1;
        for (int i = 1; i < N; i++) {
            fact[i] = fact[i - 1] * i % mod;
            rFact[i] = power(fact[i], mod - 2);
        }
        for (int i = 0; i < s.length(); i++) {
            cnt[i + 1][s.charAt(i) - 'a']++;
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < A; j++) {
                cnt[i][j] += cnt[i - 1][j];
            }
        }
    }

    /*
     * Complete the 'answerQuery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    static long answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        return calc(l, r);
    }

}

public class MaximumPalindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.txt"));

        String s = bufferedReader.readLine();

        int q = Integer.parseInt(bufferedReader.readLine().trim());
        Result.initialize(s);


        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                long result = Result.answerQuery(l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
