package com.jdavidagudelo.magic_squares;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HeapAlgorithm
{
    //Generating permutation using Heap Algorithm
    private List<List<Integer>> heapPermutation(Integer[] a, int size)
    {
        // if size becomes 1 then prints the obtained
        // permutation
        List<List<Integer>> result = new ArrayList<>();
        if (size == 1) {
            result.add(Arrays.asList(a.clone()));
            return result;
        }
        for (int i = 0; i < size; i++)
        {
            List<List<Integer>> value = heapPermutation(a, size-1);
            result.addAll(value);
            // if size is odd, swap first and last
            // element
            if (size % 2 == 1)
            {
                int temp = a[0];
                a[0] = a[size-1];
                a[size-1] = temp;
            }
            // If size is even, swap ith and last
            // element
            else
            {
                int temp = a[i];
                a[i] = a[size-1];
                a[size-1] = temp;
            }
        }
        return result;
    }

    private boolean isMagicSquare(Integer[] square, int n){
        Integer currentSum = null;
        for(int i = 0; i < n; i++) {
            int sum = 0;
            for(int j = 0; j < n; j++) {
                sum += square[i * n + j];
            }
            if(currentSum == null) {
                currentSum = sum;
            }
            if(!currentSum.equals(sum)){
                return false;
            }
        }
        for(int j = 0; j < n; j++) {
            int sum = 0;
            for(int i = 0; i < n; i++){
                sum += square[i * n + j];
            }
            if(!currentSum.equals(sum)){
                return false;
            }
        }
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += square[i * n + i];
        }
        if(currentSum != null && !currentSum.equals(sum)) {
            return false;
        }
        sum = 0;
        for(int i = 0; i < n; i++){
            sum += square[n * (n - i - 1) + i];
        }
        return currentSum != null && currentSum.equals(sum);
    }
    private List<List<Integer>> getMagicSquares(List<List<Integer>> squares, int n){
        List<List<Integer>> result = new ArrayList<>();
        for(List<Integer> square: squares){
            Integer[] squareData = (Integer[])square.toArray();
            if(this.isMagicSquare(squareData, n)){
                result.add(square);
            }
        }
        return result;
    }

    private int getCost(List<Integer> square, Integer[] data){
        Integer[] squareData = (Integer[])square.toArray();
        int cost = 0;
        for(int i = 0; i < data.length; i++){
            cost += Math.abs(data[i] - squareData[i]);
        }
        return cost;
    }

    private int getMinCost(Integer[] data, List<List<Integer>> magicSquares) {
        int minCost = Integer.MAX_VALUE;
        for(List<Integer> square: magicSquares) {
            minCost = Math.min(this.getCost(square, data), minCost);
        }
        return minCost;
    }

    private int getMinCost(int n, Integer[] data){
        Integer[] values = new Integer[n * n];
        for(int i = 0; i < n * n; i++) {
            values[i] = i + 1;
        }
        List<List<Integer>> squares = this.heapPermutation(values, values.length);
        List<List<Integer>> magicSquares = this.getMagicSquares(squares, n);
        return this.getMinCost(data, magicSquares);
    }


    // Driver code
    public static void main(String[] args)
    {
        HeapAlgorithm obj = new HeapAlgorithm();
        Integer[] values = {
                4, 9, 2,
                3, 5, 7,
                8, 1, 5};
        System.out.println(obj.getMinCost(3, values));
    }
}