package com.jdavidagudelo.misere_nim;

import java.util.HashSet;
import java.util.Set;

public class MisereNim {
    public static String nimGame(int[] piles) {
        int nimSum = 0;
        Set<Integer> s = new HashSet<>();
        for (int pi : piles) {
            nimSum ^= pi;
            s.add(pi);
        }
        if(s.size() == 1){
            if(piles[0] == 1 && piles.length % 2 == 1){
                return "Second";
            }
            else if(piles[0] == 1){
                return "First";
            }
        }
        return nimSum == 0 ? "Second" : "First";
    }
}
