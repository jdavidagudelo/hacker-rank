package com.jdavidagudelo.recursive_digit;

public class RecursiveDigit {
    public static int getSuperDigit(String s, int k){
        if(s.length() == 1){
            return Integer.parseInt(s);
        }
        long result = 0;
        for(int i = 0; i < s.length(); i++){
            result += Integer.parseInt(s.substring(i, i + 1)) * k;
        }
        return getSuperDigit(String.valueOf(result), 1);
    }
    public static void main(String[] args){
        System.out.println(getSuperDigit("148", 3));
        System.out.println(getSuperDigit("9875", 4));
        System.out.println(getSuperDigit("123", 3));
    }
}
