package com.jdavidagudelo.nimble_game;

public class NimbleGame {
    public String getWinner(int[] piles) {
        int nimSum = 0;
        for (int i = 1; i < piles.length; i++) {
            if (piles[i] % 2 == 1) {
                nimSum ^= i;
            }
        }
        if (nimSum == 0) {
            return "Second";
        }
        return "First";
    }
    public static void main(String[] args) {
        NimbleGame obj = new NimbleGame();
        System.out.println(obj.getWinner(new int[]{0, 2, 3, 0, 6}));
        System.out.println(obj.getWinner(new int[]{0, 0, 0, 0}));
    }
}
