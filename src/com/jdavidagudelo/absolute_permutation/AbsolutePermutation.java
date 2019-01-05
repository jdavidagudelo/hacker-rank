package com.jdavidagudelo.absolute_permutation;

import java.util.Arrays;

public class AbsolutePermutation {
    public int[] getSmallestPermutation(int n, int k){
        boolean[] used = new boolean[n + 1];
        int[] p = new int[n + 1];
        for(int i = 1; i <= n; i++){
            int p1 = k + i;
            int p2 = i - k;
            int d;
            if(p1 <= n && !used[p1] && p2 > 0 && !used[p2]){
                d = Math.min(p1, p2);
            }
            else if(p1 <= n && !used[p1]){
                d = p1;
            }
            else if(p2 > 0 && !used[p2]){
                d = p2;
            }
            else{
                return null;
            }
            p[i] = d;
            used[p[i]] = true;
        }
        return Arrays.copyOfRange(p, 1, p.length);
    }
    public static void main(String[] args){
        AbsolutePermutation obj = new AbsolutePermutation();
        System.out.println(Arrays.toString(obj.getSmallestPermutation(2, 1)));
        System.out.println(Arrays.toString(obj.getSmallestPermutation(3, 0)));
        System.out.println(Arrays.toString(obj.getSmallestPermutation(3, 2)));
    }
}
