package com.jdavidagudelo.permuting_arrays;

import java.util.Arrays;
import java.util.Comparator;

public class PermutingArrays {
    class ReverseComparator implements Comparator<Integer>{
        @Override
        public int compare(Integer integer, Integer t1) {
            return Integer.compare(t1, integer);
        }
    }
    public String getPermuteArray(int[] a, int[] b, int k){
        Integer[] bo = new Integer[a.length];
        for(int i = 0; i  < b.length; i++){
            bo[i] = b[i];
        }
        Arrays.sort(a);
        Arrays.sort(bo, new ReverseComparator());
        for(int i = 0; i < a.length; i++){
            if(a[i] + bo[i] < k){
                return "NO";
            }
        }
        return "YES";
    }
    public static void main(String[] args){
        PermutingArrays obj = new PermutingArrays();
        System.out.println(obj.getPermuteArray(new int[]{2, 1, 3}, new int[]{7, 8, 9}, 10));
        System.out.println(obj.getPermuteArray(new int[]{1, 2, 2, 1}, new int[]{3, 3, 3, 4}, 5));
    }
}
