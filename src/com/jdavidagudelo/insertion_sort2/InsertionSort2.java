package com.jdavidagudelo.insertion_sort2;

public class InsertionSort2 {
    public void printArray(int[] data){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public void printInsertionSort(int[] data){
        for(int i = 1; i < data.length; i++){
            for(int j = i; j > 0; j--){
                if(data[j] < data[j - 1]){
                    int aux = data[j];
                    data[j] = data[j - 1];
                    data[j - 1] = aux;
                }
            }
            printArray(data);
        }
    }

    public static void main(String[] args){
        InsertionSort2 obj = new InsertionSort2();
        obj.printInsertionSort(new int[]{1, 4, 3, 5, 6, 2});
    }
}
