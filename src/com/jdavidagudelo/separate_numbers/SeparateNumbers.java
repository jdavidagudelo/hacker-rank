package com.jdavidagudelo.separate_numbers;
import java.math.BigInteger;

public class SeparateNumbers {
    private String getNumberInitial(String s){
        int n = s.length();
        for(int i = 1; i < n; i++){
            BigInteger start = new BigInteger(s.substring(0, i));
            if(s.charAt(0) == '0'){
                return "NO";
            }
            BigInteger next = this.getNumbers(s.substring(i), start);
            if(next.compareTo(BigInteger.ZERO) > 0){
                return "YES " + start.toString();
            }
        }
        return "NO";
    }
    private BigInteger getNumbers(String s, BigInteger currentValue){
        if(s.length() == 0){
            return currentValue.add(BigInteger.valueOf(1));
        }
        int n = s.length();
        for(int i = 1; i <= n; i++){
            BigInteger start = new BigInteger(s.substring(0, i));
            if(s.charAt(0) == '0'){
                return BigInteger.valueOf(-1);
            }
            BigInteger test = start.subtract(currentValue);
            if(test.equals(BigInteger.ONE)){
                return this.getNumbers(s.substring(i), start);
            }
        }
        return BigInteger.valueOf(-1);
    }
    public static void main(String[] args){
        SeparateNumbers obj = new SeparateNumbers();
        System.out.println(obj.getNumberInitial("010203"));
        System.out.println(obj.getNumberInitial("1234"));
        System.out.println(obj.getNumberInitial("91011"));
        System.out.println(obj.getNumberInitial("99100"));
        System.out.println(obj.getNumberInitial("101103"));
        System.out.println(obj.getNumberInitial("13"));
        System.out.println(obj.getNumberInitial("1"));
        System.out.println(obj.getNumberInitial("99910001001"));
        System.out.println(obj.getNumberInitial("7891011"));
        System.out.println(obj.getNumberInitial("9899100"));
        System.out.println(obj.getNumberInitial("999100010001"));

        System.out.println(obj.getNumberInitial("10001001100210031004100510061007"));
        System.out.println(obj.getNumberInitial("11111111111111111111111111111111"));
    }
}
