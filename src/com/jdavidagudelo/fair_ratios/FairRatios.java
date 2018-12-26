package com.jdavidagudelo.fair_ratios;

public class FairRatios {
    public int getData(int[] data){
        int sum = 0;
        for(int d: data){
            sum += d;
        }
        if(sum % 2 != 0){
            return -1;
        }
        int count = 0;
        for(int i = 0; i < data.length; i++){
            if(data[i] % 2 != 0){
                data[i + 1] += 1;
                count += 2;
            }
        }
        return count;
    }
    public static void main(String[] args){
        FairRatios obj = new FairRatios();
        int[] d = {2, 3, 4, 5, 6};
        int result = obj.getData(d);
        System.out.println(result);
    }
}
