package com.jdavidagudelo.connected_cells;

import java.util.Stack;

public class ConnectedCells {
    boolean[][] visited;
    class Node{
        int x;
        int y;
        Node(int i, int j){
            x = i;
            y = j;
        }
    }
    public int dfs(int[][] grid, int i, int j, int m, int n){
        int[][] deltas = new int[][]{
                {0, 1},
                {0, -1},
                {1, 0},
                {1, -1},
                {1, 1},
                {-1, 0},
                {-1, -1},
                {-1, 1},
        };
        Stack<Node> q = new Stack<>();
        q.push(new Node(i, j));
        int count = 0;
        while(!q.isEmpty()){
            Node current = q.pop();
            if(visited[current.x][current.y]){
                continue;
            }
            visited[current.x][current.y] = true;
            count += 1;
            for(int[] di: deltas){
                int x = current.x + di[0];
                int y = current.y + di[1];
                if(x >= 0 && x < m && y >= 0 && y < n && grid[x][y] > 0){
                    q.push(new Node(x, y));
                }
            }
        }
        return count;
    }
    public int getMaximumArea(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        int result = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] > 0){
                    result = Math.max(result, dfs(grid, i, j, m, n));
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        ConnectedCells obj = new ConnectedCells();
        int[][] g = new int[][]{
                {1, 1, 0, 0},
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0}
        };
        System.out.println(obj.getMaximumArea(g));
        g = new int[][]{
                {0, 0, 1, 1},
                {0, 0, 1, 0},
                {0, 1, 1, 0},
                {0, 1, 0, 0},
                {1, 1, 0, 0}
        };

        System.out.println(obj.getMaximumArea(g));
    }
}
