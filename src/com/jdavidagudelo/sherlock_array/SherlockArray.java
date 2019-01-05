package com.jdavidagudelo.sherlock_array;

public class SherlockArray {

    public String existsElement(int[] data){
        int[] sumLeft = new int[data.length];
        int[] sumRight = new int[data.length];
        for(int i = 1; i < data.length; i++){
            if(i == 1){
                sumLeft[i] = data[i - 1];
            }
            else {
                sumLeft[i] = sumLeft[i - 1] + data[i - 1];
            }
        }
        for(int i = data.length - 2; i >= 0; i--){
            if(i == data.length - 2){
                sumRight[i] = data[i + 1];
            }
            else {
                sumRight[i] = sumRight[i + 1] + data[i + 1];
            }
        }
        for(int i = 0; i < data.length; i++){
            if(sumLeft[i] == sumRight[i]){
                return "YES";
            }
        }
        return "NO";
    }

    public static void main(String[] args){
        SherlockArray obj = new SherlockArray();
        System.out.println(obj.existsElement(new int[]{1, 2, 3}));
        System.out.println(obj.existsElement(new int[]{1, 2, 3, 3}));
        System.out.println(obj.existsElement(new int[]{1, 1, 4, 1, 1}));
        System.out.println(obj.existsElement(new int[]{2, 0, 0, 0}));
        System.out.println(obj.existsElement(new int[]{0, 0, 2, 0}));
    }
}
