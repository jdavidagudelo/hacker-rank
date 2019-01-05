package com.jdavidagudelo.insertion_sort_runtime;

public class InsertionSortRunTime {
    public int printInsertionSort(int[] data){
        int count = 0;
        for(int i = 1; i < data.length; i++){
            for(int j = i; j > 0; j--){
                if(data[j] < data[j - 1]){
                    int aux = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = aux;
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        InsertionSortRunTime obj = new InsertionSortRunTime();
        int result = obj.printInsertionSort(new int[]{2, 1, 3, 1, 2});
        System.out.println(result);
    }
}
