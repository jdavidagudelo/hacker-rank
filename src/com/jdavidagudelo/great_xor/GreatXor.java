package com.jdavidagudelo.great_xor;

public class GreatXor {
    public long theGreatXor(long x) {
        int count = 0;
        for(int a = 1; a < x; a++){
            if((a ^ x) > x){
                count += 1;
            }
        }
        return count;
    }
    public static void main(String[] args){
        GreatXor obj = new GreatXor();
        System.out.println(obj.theGreatXor(2));
        System.out.println(obj.theGreatXor(5));
        System.out.println(obj.theGreatXor(10));
        System.out.println(obj.theGreatXor(100));
    }
}
