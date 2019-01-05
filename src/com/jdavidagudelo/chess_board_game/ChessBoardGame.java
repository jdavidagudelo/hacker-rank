package com.jdavidagudelo.chess_board_game;

public class ChessBoardGame {
    private Boolean[][] cache = new Boolean[16][16];
    public boolean call(int x, int y){
        if(x < 1 || y < 1 || x > 15 || y > 15){
            return true;
        }
        if(cache[x][y] != null){
            return cache[x][y];
        }
        boolean state = call(x - 1, y - 2);
        state = state & call(x + 1, y - 2);
        state = state & call(x - 2, y + 1);
        state = state & call(x - 2, y - 1);
        cache[x][y] = !state;
        return cache[x][y];
    }
    public static void main(String[] args){

    }
}
