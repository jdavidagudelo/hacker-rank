package com.jdavidagudelo.count_luck;

import java.util.Stack;

public class CountLuck {
    private boolean[][] visited;
    class Node{
        int x;
        int y;
        Integer ct;
        int turns;
        Node(int i, int j, Integer p, int t){
            x = i;
            y = j;
            ct = p;
            turns = t;
        }
        public String toString(){
            return "(" + x + ", " + y + ")";
        }
    }
    public int dfs(char[][] g, int r, int c, int m, int n){
        visited = new boolean[m][n];
        int[][] deltas = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };
        Stack<Node> q = new Stack<>();
        q.push(new Node(r, c, null, 0));
        while(!q.isEmpty()){
            Node current = q.pop();
            if(visited[current.x][current.y]){
                continue;
            }
            visited[current.x][current.y] = true;
            if(g[current.x][current.y] == '*'){
                return current.turns;
            }
            int paths = 0;
            for (int[] delta : deltas) {
                int x = current.x + delta[0];
                int y = current.y + delta[1];
                if (x >= 0 && x < m && y >= 0 && y < n && g[x][y] != 'X' && !visited[x][y]) {
                    paths += 1;
                }
            }
            for(int i = 0; i < deltas.length; i++){
                int x = current.x + deltas[i][0];
                int y = current.y + deltas[i][1];
                if(x >= 0 && x < m && y >= 0 && y <  n && g[x][y] != 'X' && !visited[x][y]){
                    int turns = 0;
                    if(paths > 1){
                        turns = 1;
                    }
                    q.push(new Node(x, y, i, current.turns + turns));
                }
            }
        }
        return 0;
    }

    String countLuck(String[] matrix, int k){
        int m = matrix.length;
        int n = matrix[0].length();
        char[][] g = new char[m][n];
        int r = 0;
        int c = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                g[i][j] = matrix[i].charAt(j);
                if(g[i][j] == 'M'){
                    r = i;
                    c = j;
                }
            }
        }
        int result = dfs(g, r, c, m, n);
        System.out.println(result);
        return result == k? "Impressed": "Oops!";
    }

    public static void main(String[] args){
        CountLuck obj = new CountLuck();
        String[] g = new String[]{
                "*.M",
                ".X."
        };
        System.out.println(obj.countLuck(g, 1));
        g = new String[]{
                ".X.X......X",
                ".X*.X.XXX.X",
                ".XX.X.XM...",
                "......XXXX."
        };
        System.out.println(obj.countLuck(g, 3));
        System.out.println(obj.countLuck(g, 4));
        g = new String[]{
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.",
                "M.......................................*",
                ".X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X.X."
        };
        System.out.println(obj.countLuck(g, 20));
    }
}
