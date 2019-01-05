package com.jdavidagudelo.beautiful_binary;

public class BeautifulBinary {
    public int getMinimumMoves(String b){
        return (b.length() - b.replaceAll("010", "").length())/3;
    }
    public static void main(String[] args){
        BeautifulBinary obj = new BeautifulBinary();
        System.out.println(obj.getMinimumMoves("010"));
    }
}
