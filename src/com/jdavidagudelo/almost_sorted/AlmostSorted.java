package com.jdavidagudelo.almost_sorted;


public class AlmostSorted {
    public static String almostSortedFunction(int[] d) {
        int n = d.length;
        int i, j;
        for (i = 0; i < n - 1 && d[i] < d[i + 1]; ++i) {

        }
        for (j = n - 1; j > 0 && d[j - 1] < d[j]; --j) {

        }

        // try swap
        swap(d, i, j);
        if (isAsc(d)) {
            return "yes\nswap " + (i + 1) + " " + (j + 1);
        }

        // try reverse (continue reversing inner pairs)
        int k = i + 1, l = j - 1;
        while (k < l)
            swap(d, k++, l--);
        if (isAsc(d)) {
            return "yes\nreverse " + (i + 1) + " " + (j + 1);
        }
        return "no";
    }
    public static void swap(int[] d, int i, int j) {
        int tmp = d[i];
        d[i] = d[j];
        d[j] = tmp;
    }

    public static boolean isAsc(int[] d) {
        for (int i = 0; i < d.length-1; ++i) {
            if (d[i] > d[i+1]) return false;
        }
        return true;
    }
    public static void main(String[] args){

    }
}
