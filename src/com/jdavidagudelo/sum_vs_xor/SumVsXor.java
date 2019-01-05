package com.jdavidagudelo.sum_vs_xor;

public class SumVsXor {
    public long getSumVsXor(long n){
        int power = 0;
        long x = n;
        while(x > 0){
            power += 1;
            x >>= 1;
        }

        int[] number = new int[power];
        x = n;
        int index = 0;
        while(x > 0){
            number[index] = (int)(x % 2);
            x >>= 1;
            index += 1;
        }
        int unsetBits = 0;
        for (int i1 : number) {
            unsetBits += i1 == 0 ? 1 : 0;
        }
        return (long)Math.pow(2, unsetBits);
    }
    public static void main(String[] args){
        SumVsXor obj = new SumVsXor();
        System.out.println(obj.getSumVsXor(5));
        System.out.println(obj.getSumVsXor(10));
    }
}
