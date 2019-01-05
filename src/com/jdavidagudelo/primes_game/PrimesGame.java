package com.jdavidagudelo.primes_game;

import java.util.Arrays;

public class PrimesGame {

    public int getPrimes(int n){
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        for(int p = 2; p * p <= n; p++){
            if(prime[p]){
                for(int i = p *p; i <= n; i += p){
                    prime[i] = false;
                }
            }
        }
        int primes = 0;;
        for(int i = 0; i <= n; i++){
            primes += prime[i]? 1: 0;
        }
        return primes;
    }

    public String getWinner(int n){
        int result = getPrimes(n);
        return result % 2 == 0? "Bob": "Alice";
    }

    public static void main(String[] args){
        PrimesGame obj = new PrimesGame();
        System.out.println(obj.getWinner(1));
        System.out.println(obj.getWinner(2));
        System.out.println(obj.getWinner(5));
    }
}
