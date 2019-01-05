package com.jdavidagudelo.bomberman_game;

import java.util.Arrays;

public class BomberManGame {
    public String[] decodeBoard(int m, int n, int[][] aux){
        String[] result = new String[m];
        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(aux[i][j] > 0){
                    sb.append("O");
                }
                else{
                    sb.append(".");
                }
            }
            result[i] = sb.toString();
        }
        return result;
    }
    public String[] getAllBombsGrid(int m, int n){
        String[] result = new String[m];
        for(int i = 0; i < m; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++){
                sb.append("O");
            }
            result[i] = sb.toString();
        }
        return result;
    }
    public int[][] getExplodedBoard(int m, int n, int[][] g) {
        int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] aux = new int[m][n];
        for(int i = 0; i < m; i++){
            System.arraycopy(g[i], 0, aux[i], 0, n);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(g[i][j] - 1 == 0){
                    for (int[] deltas : d) {
                        int x = i + deltas[0];
                        int y = j + deltas[1];
                        if (x >= 0 && x < m && y >= 0 && y < n) {
                            aux[x][y] = 0;
                        }
                    }
                    aux[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                aux[i][j] = Math.max(0, aux[i][j] - 1);
            }
        }
        return aux;
    }
    public String[] getPosition(String[] grid, int t){
        int m = grid.length;
        int n = grid[0].length();
        String[][] positions = new String[5][m];
        positions[1] = Arrays.copyOfRange(grid, 0, m);
        int[][] g = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                g[i][j] = grid[i].charAt(j) == 'O'? 2: 0;
            }
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                g[i][j] = g[i][j] == 0? 3: g[i][j] - 1;
            }
        }
        positions[2] = getAllBombsGrid(m, n);
        int[][] aux = getExplodedBoard(m, n, g);
        positions[3] = decodeBoard(m, n, aux);
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                aux[i][j] = aux[i][j] == 0? 3: aux[i][j] - 1;
            }
        }
        for(int i = 0; i < m; i++){
            System.arraycopy(aux[i], 0, g[i], 0, n);
        }
        aux = getExplodedBoard(m, n, g);
        positions[4] = decodeBoard(m, n, aux);
        if(t == 1){
            return positions[1];
        }
        if(t % 2 == 0){
            return positions[2];
        }
        if((t - 3) % 4 == 0){
            return positions[3];
        }
        return positions[4];
    }
    public static void main(String[] args){
        BomberManGame obj = new BomberManGame();
        String[] grid = new String[]{
                ".......",
                "...O...",
                "....O..",
                ".......",
                "OO.....",
                "OO....."
        };
        System.out.println(Arrays.toString(obj.getPosition(grid, 3)));
        System.out.println(Arrays.toString(obj.getPosition(grid, 2)));
        System.out.println(Arrays.toString(obj.getPosition(grid, 3)));
        System.out.println(Arrays.toString(obj.getPosition(grid, 4)));
        System.out.println(Arrays.toString(obj.getPosition(grid, 5)));
        System.out.println(Arrays.toString(obj.getPosition(grid, 6)));
        System.out.println(Arrays.toString(obj.getPosition(grid, 7)));
        System.out.println(Arrays.toString(obj.getPosition(grid, 8)));
        String[] newGrid = new String[]{"O..OO........O..O........OO.O.OO.OO...O.....OOO...OO.O..OOOOO...O.O..O..O.O..OOO..O..O..O....O...O....O...O..O..O....O.O.O.O.....O.....OOOO..O......O.O.....OOO....OO....OO....O.O...O..OO....OO..O...O"};

        System.out.println(Arrays.toString(obj.getPosition(newGrid, 2)));
    }
}
