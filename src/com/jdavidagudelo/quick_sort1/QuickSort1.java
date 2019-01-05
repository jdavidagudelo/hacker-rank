package com.jdavidagudelo.quick_sort1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickSort1 {
    public int[] getPivotArray(int[] data){
        int pivot = data[0];
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        for(int d: data){
            if(d > pivot){
                right.add(d);
            }
            else if(d < pivot){
                left.add(d);
            }
            else{
                equal.add(d);
            }
        }
        left.addAll(equal);
        left.addAll(right);
        int k = 0;
        int[] result = new int[data.length];
        for(int d: left){
            result[k] = d;
            k += 1;
        }
        return result;
    }
    public static void main(String[] args){
        QuickSort1 obj = new QuickSort1();
        int[] result = obj.getPivotArray(new int[] {4, 5, 3, 7, 2});
        System.out.println(Arrays.toString(result));
    }
}
