package com.jdavidagudelo.beautiful_pairs;

import java.util.HashSet;
import java.util.Set;

public class BeautifulPairs {
    public int getBeautifulPairs(int[] A, int[] B){
        int[] bucketA = new int[1000 + 1];
        for(int i = 0; i < A.length; i++){
            bucketA[A[i]] += 1;
        }
        int count = 0;
        for(int i = 0; i < A.length; i++){
            if(bucketA[B[i]] > 0){
                bucketA[B[i]] -= 1;
                count += 1;
            }
        }
        if(count == A.length){
            count -= 1;
        }
        else{
            count += 1;
        }
        return count;
    }
    public static void main(String[] args){
        BeautifulPairs obj = new BeautifulPairs();
        System.out.println(obj.getBeautifulPairs(new int[]{1, 2, 3, 4}, new int[]{1, 2, 3, 3}));
        System.out.println(obj.getBeautifulPairs(new int[]{3, 5, 7, 11, 5, 8}, new int[]{5, 7, 11, 10, 5, 8}));
    }
}
