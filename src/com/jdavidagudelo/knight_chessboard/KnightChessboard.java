package com.jdavidagudelo.knight_chessboard;

import java.util.Arrays;
import java.util.TreeSet;

public class KnightChessboard {

    class Node implements Comparable<Node>{
        int x;
        int y;
        int t;
        Node(int i, int j, int k){
            x = i;
            y = j;
            t = k;
        }
        public int compareTo(Node other){
            if(t != other.t){
                return Integer.compare(t, other.t);
            }
            if(x != other.x){
                return Integer.compare(x, other.x);
            }
            return Integer.compare(y, other.y);
        }
    }
    public int[][] getMinimums(int n){
        int[][] result = new int[n - 1][n - 1];
        for(int a = 1; a < n; a++){
            for(int b = 1; b < n; b++){
                result[a - 1][b - 1] = getMinValue(n, a, b);
            }
        }
        return result;
    }

    public int getMinValue(int n, int a, int b){
        Node start = new Node(0, 0, 0);
        TreeSet<Node> q = new TreeSet<>();
        int[][] d = new int[][]{
                {a, b},
                {a, -b},
                {b, a},
                {b, -a},
                {-a, b},
                {-a, -b},
                {-b, a},
                {-b, -a}
        };
        q.add(start);
        boolean[][] visited = new boolean[n][n];
        while(!q.isEmpty()){
            Node current = q.pollFirst();
            if(current == null){
                continue;
            }
            if(current.x == n - 1 && current.y == n - 1){
                return current.t;
            }
            for(int[] di: d){
                int x = current.x + di[0];
                int y = current.y + di[1];
                if(x >= 0 && x < n && y >= 0 && y < n){
                    if(!visited[x][y]){
                        q.add(new Node(x, y, current.t + 1));
                    }
                }
            }
            visited[current.x][current.y] = true;
        }
        return -1;
    }

    public static void main(String[] args){
        KnightChessboard obj = new KnightChessboard();
        int[][] result = obj.getMinimums(5);
        for(int[] ri: result){
            System.out.println(Arrays.toString(ri));
        }
    }
}
