package com.jdavidagudelo.red_knight_shortest_path;

import sun.reflect.generics.tree.Tree;

import java.util.*;

public class RedKnightShortestPath {

    class Node implements Comparable<Node>{
        int x;
        int y;
        int t;
        int move;


        Node(int i, int j, int time, int m){
            x = i;
            y = j;
            t = time;
            move = m;
        }
        @Override
        public int compareTo(Node node) {
            if(t != node.t){
                return Integer.compare(t, node.t);
            }
            if(move != node.move){
                return Integer.compare(move, node.move);
            }
            if(x != node.x){
                return Integer.compare(x, node.x);
            }
            return Integer.compare(y, node.y);
        }

    }
    class Tuple{
        int x;
        int y;
        Tuple(int i, int j){
            x = i;
            y = j;
        }
    }
    void printRoute(int[][] m, int xf, int yf, int n){
        int[][] deltas = new int[][]{
                {2, 1},
                {2, -1},
                {0, -2},
                {-2, -1},
                {-2, 1},
                {0, 2}
        };
        String[] moves = new String[]{
                "UL", "UR", "R", "LR", "LL", "L"
        };
        int x = xf;
        int y = yf;
        while(x >= 0 && x < n && y >= 0 && y < n && m[x][y] >= 0){
            int move = m[x][y];
            System.out.print(moves[move] + " ");
            x += deltas[move][0];
            y += deltas[move][1];
        }
        System.out.println();
    }

    public void solve(int n, int iStart, int jStart, int iEnd, int jEnd){
        int[][] deltas = new int[][]{
                {-2, -1},
                {-2, 1},
                {0, 2},
                {2, 1},
                {2, -1},
                {0, -2}
        };
        int[][] moves = new int[n][n];
        for(int[] mi: moves){
            Arrays.fill(mi, -1);
        }
        boolean[][] visited = new boolean[n][n];
        TreeSet<Node> q = new TreeSet<>();
        q.add(new Node(iStart, jStart, 0, -1));
        while(!q.isEmpty()) {
            Node current = q.pollFirst();
            if(current == null){
                continue;
            }
            if(current.x < 0 || current.x >= n || current.y < 0 || current.y >= n){
                continue;
            }
            if(visited[current.x][current.y]){
                continue;
            }
            moves[current.x][current.y] = current.move;
            if(current.x == iEnd && current.y == jEnd){
                System.out.println(current.t);
                printRoute(moves, iEnd, jEnd, n);
                return;
            }
            visited[current.x][current.y] = true;
            for(int i = 0; i < deltas.length; i++){
                int x = deltas[i][0] + current.x;
                int y = deltas[i][1] + current.y;
                Node newNode = new Node(x, y, current.t + 1, i);
                q.add(newNode);
            }
        }
        System.out.println("Impossible");
    }

    public static void main(String[] args){
        RedKnightShortestPath obj = new RedKnightShortestPath();
        obj.solve(7, 6, 6, 0, 1);
        obj.solve(5, 4, 1, 0, 3);
        obj.solve(70, 7, 15, 67, 3);
    }
}
