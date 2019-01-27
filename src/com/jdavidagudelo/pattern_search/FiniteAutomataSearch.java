package com.jdavidagudelo.pattern_search;

public class FiniteAutomataSearch {


    private static int[][] computeTransFun(String pat, int M, int numberOfChars)
    {
        int[][] tf = new int[M + 1][numberOfChars];
        int i, lps = 0, x;

        // Fill entries in first row
        for (x =0; x < numberOfChars; x++) {
            tf[0][x] = 0;
        }
        tf[0][pat.charAt(0)] = 1;

        // Fill entries in other rows
        for (i = 1; i<= M; i++)
        {
            // Copy values from row at index lps
            for (x = 0; x < numberOfChars; x++) {
                tf[i][x] = tf[lps][x];
            }

            // Update the entry corresponding to this character

            // Update lps for next row to be filled
            if (i < M) {
                tf[i][pat.charAt(i)] = i + 1;
                lps = tf[lps][pat.charAt(i)];
            }
        }
        return tf;
    }

    /* Prints all occurrences of pat in txt */
    private static void search(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        int[][] tf = computeTransFun(pat, M, 256);

        // process text over FA.
        int i, j = 0;
        for (i = 0; i < N; i++)
        {
            j = tf[j][txt.charAt(i)];
            if (j == M) {
                System.out.println ("\n pattern found at index %d" + (i - M + 1));
            }
        }
    }
    public static void main(String[] args){
        String txt = "GEEKS FOR GEEKS";
        String pat = "GEEKS";
        search(pat, txt);
    }
}
