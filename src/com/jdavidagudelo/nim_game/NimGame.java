package com.jdavidagudelo.nim_game;

public class NimGame {
    public String nimGame(int[] piles){
        int nimSum = 0;
        for(int pi: piles){
            nimSum ^= pi;
        }
        return nimSum == 0? "Second": "First";
    }
    public static void main(String[] args){

    }
}
