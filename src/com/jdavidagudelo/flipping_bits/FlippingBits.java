package com.jdavidagudelo.flipping_bits;


public class FlippingBits {

    public long flipBits(long n){
        int[] number = new int[32];
        long x = n;
        int index = 0;
        while(x > 0){
            number[index] = (int)(x % 2);
            x >>= 1;
            index += 1;
        }
        for(int i = 0; i < number.length; i++){
            number[i] = number[i] == 0? 1: 0;
        }
        long result = 0;
        for(int i = 0; i < number.length; i++){
            result += Math.pow(2, i) * number[i];
        }
        return result;
    }

    public static void main(String[] args){
        FlippingBits obj = new FlippingBits();
        System.out.println(obj.flipBits(2147483647));
        System.out.println(obj.flipBits(1));
        System.out.println(obj.flipBits(0));
    }
}
