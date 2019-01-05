package com.jdavidagudelo.insertion_sort1;

public class InsertionSort1 {
    public void printArray(int[] data){
        for(int i = 0; i < data.length; i++){
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
    public void printInsertion(int[] data){
        int v = data[data.length - 1];
        boolean added = false;
        for(int i = data.length - 2; i >= 0; i--){
            if(data[i] > v){
                data[i + 1] = data[i];
                printArray(data);
            }
            else if(!added){
                added = true;
                data[i + 1] = v;
                printArray(data);
            }
        }
        if(!added){
            data[0] = v;
            printArray(data);
        }
    }
    public static void main(String[] args){
        InsertionSort1 obj = new InsertionSort1();
        obj.printInsertion(new int[] {2, 4, 6, 8, 1});
        System.out.println();
        obj.printInsertion(new int[] {1, 3, 5, 9, 13, 22, 27, 35, 46, 51, 55, 83, 87, 23});
    }
}
