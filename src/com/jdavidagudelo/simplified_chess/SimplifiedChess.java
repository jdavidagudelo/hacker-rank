package com.jdavidagudelo.simplified_chess;

import java.util.*;

public class SimplifiedChess {


    static class Move{
        int row;
        int column;
        Move(int r, int c){
            row = r;
            column = c;
        }
    }

    static class ChessPiece implements Cloneable{
        // 0 white, 1 black
        int player;
        char type;
        ChessPiece(int p, char t){
            player = p;
            type = t;
        }
        public String toString(){
            return String.valueOf(type) + ", " + String.valueOf(player);
        }
        public ChessPiece clone(){
            return new ChessPiece(player, type);
        }
    }

    static ChessPiece[][] copyBoard(ChessPiece[][] board){
        ChessPiece[][] result = new ChessPiece[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] != null) {
                    result[i][j] = board[i][j].clone();
                }
            }
        }
        return result;
    }

    static boolean isWin(ChessPiece[][] board){
        for(ChessPiece[] p: board){
            for(ChessPiece piece: p){
                if(piece != null && piece.type == 'Q' && piece.player == 1) {
                    return false;
                }
            }
        }
        return true;
    }
    static boolean isLost(ChessPiece[][] board){
        for(ChessPiece[] p: board){
            for(ChessPiece piece: p){
                if(piece != null && piece.type == 'Q' && piece.player == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    static List<Move> getMovesQueen(ChessPiece[][] board, int r, int c){
        List<Move> result = getMovesRook(board, r, c);
        result.addAll(getMovesBishop(board, r, c));
        return result;
    }

    static List<Move> getMovesKnight(ChessPiece[][] board, int r, int c){
        List<Move> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        int[][] moves = new int[][]{
                {-2, 1},
                {-1, 2},
                {1, 2},
                {2, 1},
                {2, -1},
                {1, -2},
                {-1, -2},
                {-2, -1},
        };
        for(int[] move: moves){
            int i = r + move[0];
            int j = c + move[1];
            if(i < m && i >= 0 && j < n && j >= 0){
                result.add(new Move(i, j));
            }
        }
        return result;
    }

    static List<Move> getMovesBishop(ChessPiece[][] board, int r, int c){
        List<Move> result = new ArrayList<>();
        int m = board.length;
        int n = board[0].length;
        boolean blocked = false;

        for(int i = r + 1; i < m && !blocked; i++){
            for(int j = c + 1; j < n && !blocked; j++){
                result.add(new Move(i, j));
                blocked = board[i][j] != null;
            }
        }
        blocked = false;
        for(int i = r + 1; i < m && !blocked; i++){
            for(int j = c - 1; j >= 0 && !blocked; j--){
                result.add(new Move(i, j));
                blocked = board[i][j] != null;
            }
        }
        blocked = false;
        for(int i = r - 1; i >= 0 && !blocked; i--){
            for(int j = c - 1; j >= 0 && !blocked; j--){
                result.add(new Move(i, j));
                blocked = board[i][j] != null;
            }
        }
        blocked = false;
        for(int i = r - 1; i >= 0 && !blocked; i--){
            for(int j = c + 1; j < n && !blocked; j++){
                result.add(new Move(i, j));
                blocked = board[i][j] != null;
            }
        }
        return result;
    }

    static List<Move> getMovesRook(ChessPiece[][] board, int r, int c){
        int m = board.length;
        int n = board[0].length;
        List<Move> result = new ArrayList<>();
        boolean blocked = false;
        for(int i = r + 1; i < m && !blocked; i++){
            result.add(new Move(i, c));
            blocked = board[i][c] != null;
        }
        blocked = false;
        for(int i = r - 1; i >= 0 && !blocked; i--){
            result.add(new Move(i, c));
            blocked = board[i][c] != null;
        }
        blocked = false;
        for(int j = c + 1; j < n && !blocked; j++){
            result.add(new Move(r, j));
            blocked = board[r][j] != null;
        }
        blocked = false;
        for(int j =  c - 1; j >= 0 && !blocked; j--){
            result.add(new Move(r, j));
            blocked = board[r][j] != null;
        }
        return result;
    }

    static List<Move> getMoves(ChessPiece[][] board, int r, int c){
        List<Move> result = new ArrayList<>();
        if(board[r][c] == null){
            return result;
        }
        if(board[r][c].type == 'Q'){
            return getMovesQueen(board, r, c);
        }
        else if(board[r][c].type == 'N'){
            return getMovesKnight(board, r, c);
        }
        else if(board[r][c].type == 'R'){
            return getMovesRook(board, r, c);
        }
        return getMovesBishop(board, r, c);
    }
    static void printBoard(ChessPiece[][] board){
        for (ChessPiece[] chessPieces : board) {
            System.out.println(Arrays.toString(chessPieces));
        }
    }

    public static boolean canWin(ChessPiece[][] board, int moves, int player){
        int m = board.length;
        int n = board[0].length;

        if(isWin(board)){
            return true;
        }
        if(isLost(board)){
            return false;
        }
        if(moves == 0){
            return player == 0;
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] != null && board[i][j].player == player) {
                    List<Move> current = getMoves(board, i, j);
                    for (Move move : current) {
                        if (board[move.row][move.column] == null || board[move.row][move.column].player != player) {
                            ChessPiece[][] cloned = copyBoard(board);
                            cloned[move.row][move.column] = cloned[i][j];
                            cloned[i][j] = null;
                            int newPlayer = 0;
                            if (player == 0) {
                                newPlayer = 1;
                            }
                            boolean result = canWin(cloned, moves - 1, newPlayer);
                            if(!result || board[move.row][move.column] != null && board[move.row][move.column].player != player && board[move.row][move.column].type == '@'){
                                return true;
                            }
                        }
                    }
                }

            }
        }
        return false;
    }

    static boolean solve(char[][] whites, char[][] blacks, int moves){
        ChessPiece[][] board = new ChessPiece[4][4];
        Map<Character, Integer> rows = new HashMap<>();
        rows.put('1', 3);
        rows.put('2', 2);
        rows.put('3', 1);
        rows.put('4', 0);
        Map<Character, Integer> columns = new HashMap<>();
        columns.put('A', 0);
        columns.put('B', 1);
        columns.put('C', 2);
        columns.put('D', 3);
        for (char[] w : whites) {
            board[rows.get(w[2])][columns.get(w[1])] = new ChessPiece(0, w[0]);
        }
        for(char[] b: blacks){
            board[rows.get(b[2])][columns.get(b[1])] = new ChessPiece(1, b[0]);
        }
        return canWin(board, moves, 0);
    }

    public static void main(String[] args){
        boolean result = solve(new char[][]{
                {'N', 'B', '2'},
                {'Q', 'B', '1'},
        }, new char[][]{
                {'Q', 'A', '4'}}, 1);
        System.out.println(result);

        result = solve(new char[][]{
                {'Q', 'C', '1'},
        }, new char[][]{
                {'Q', 'B', '3'}}, 4);
        System.out.println(result);


        result = solve(new char[][]{
                {'N', 'C', '2'},
                {'R', 'A', '1'},
                {'Q', 'D', '4'}
        }, new char[][]{
                {'R', 'A', '4'},
                {'R', 'B', '4'},
                {'N', 'A', '3'},
                {'N', 'C', '3'},
                {'Q', 'A', '2'}}, 6);
        System.out.println(result);


        result = solve(new char[][]{
                {'Q', 'A', '2'}
        }, new char[][]{
                {'N', 'D', '2'},
                {'R', 'B', '2'},
                {'Q', 'D', '4'}
        }, 2);
        System.out.println(result);
    }
}
