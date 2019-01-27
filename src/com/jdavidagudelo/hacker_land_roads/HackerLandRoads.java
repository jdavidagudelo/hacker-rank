package com.jdavidagudelo.hacker_land_roads;

import com.jdavidagudelo.lisa_workbook.LisaWorkBook;

import java.util.*;

public class HackerLandRoads {

    class BasicBinary implements Comparable<BasicBinary>{
        int[] digits;
        int maxDigit;

        BasicBinary(int[] d, int max){
            digits = new int[d.length];
            System.arraycopy(d, 0, digits, 0, d.length);
            maxDigit = max;
        }

        BasicBinary(int m, int p){
            digits = new int[m];
            digits[p] = 1;
            maxDigit = p;
        }

        BasicBinary(int m){
            digits = new int[m];
            maxDigit = 0;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            for(int digit: digits){
                sb.append(digit).append(" ");
            }
            return sb.toString().trim();
        }
        public int compareTo(BasicBinary other){
            if(maxDigit != other.maxDigit){
                return Integer.compare(maxDigit, other.maxDigit);
            }
            for(int i = maxDigit; i >= 0; i--){
                if(digits[i] != other.digits[i]){
                    return Integer.compare(digits[i], other.digits[i]);
                }
            }
            return 0;
        }
        public BasicBinary add(int d){
            BasicBinary b = new BasicBinary(digits, Math.max(maxDigit, d));
            b.digits[d] = 1;
            return b;
        }
    }

    class Node implements Comparable<Node>{
        int v;
        BasicBinary w;

        Node(int i, BasicBinary b){
            v = i;
            w = b;
        }

        public int compareTo(Node other){
            int result = w.compareTo(other.w);
            if(result != 0){
                return result;
            }
            return Integer.compare(v, other.v);
        }
    }

    class Edge{
        int v;
        int w;
        Edge(int i, int t){
            v = i;
            w = t;
        }
    }

    public int[] bfs(Map<Integer, List<Edge>> adj, int n, int m){
        boolean[] visited = new boolean[n];
        TreeSet<Node> q = new TreeSet<>();
        q.add(new Node(0, new BasicBinary(m)));
        while(!q.isEmpty()){
            Node current = q.pollFirst();
            if(current == null || visited[current.v]){
                continue;
            }
            visited[current.v] = true;
            for(Edge v: adj.get(current.v)){
                q.add(new Node(v.v, current.w.add(v.w)));
            }
        }
        return null;
    }

    public String getResult(int n, int[][] roads){
        int m = roads.length;
        Map<Integer, List<Edge>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            int x = road[0] - 1;
            int y = road[1] - 1;
            int w = road[2];
            List<Edge> current = adj.get(x);
            current.add(new Edge(y, w));
            current = adj.get(y);
            current.add(new Edge(x, w));
        }
        return null;
    }

    public static void main(String[] args){

    }
}
