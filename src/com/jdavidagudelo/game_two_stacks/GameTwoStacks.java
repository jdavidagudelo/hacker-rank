package com.jdavidagudelo.game_two_stacks;

public class GameTwoStacks {


    public static int getNumberOfGames(int[] a, int[] b, int x){
        int ai = 0;
        int bi = 0;
        int count = 0;
        int sum = 0;
        // move bi to the position where if only take elements from B, last element it can take
        while (bi < b.length && sum + b[bi] <= x) {
            sum += b[bi];
            bi++;
        }
        bi--; // loop exits only when bi reaches end or sum > x; in both case bi should decrease
        count = bi + 1;
        while (ai < a.length && bi < b.length) {
            sum += a[ai];
            if (sum > x) {
                while (bi >= 0) {
                    sum -= b[bi];
                    bi--;
                    if (sum <= x) break;
                }
                // if even no elements taken from B, but still sum greater than x, then a[ai] should not be chosen
                // and loop terminates
                if (sum > x && bi < 0) {
                    break;
                }
            }
            count = Math.max(ai + bi + 2, count);
            ai++;
        }

        return count;
    }

    public static void main(String[] args){
        int v = GameTwoStacks.getNumberOfGames(new int[]{4, 2, 4, 6, 1}, new int[]{2, 1, 8, 5}, 10);
        System.out.println(v);
    }

}
