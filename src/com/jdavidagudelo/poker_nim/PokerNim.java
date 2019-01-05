package com.jdavidagudelo.poker_nim;

public class PokerNim {
    public String getWinner(int[] c, int k){
        int nimSum = 0;
        for(int pi: c){
            nimSum ^= pi;
        }
        return nimSum == 0? "Second": "First";
    }
    public static void main(String[] args){

    }
}
