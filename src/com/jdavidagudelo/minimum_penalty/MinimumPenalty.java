package com.jdavidagudelo.minimum_penalty;

import java.util.*;

public class MinimumPenalty {
    class Node implements Comparable<Node>{
        int x;
        int t;
        Node(int i, int k){
            x = i;
            t = k;
        }

        @Override
        public int compareTo(Node node) {
            if(t != node.t){
                return Integer.compare(t, node.t);
            }
            return Integer.compare(x, node.x);
        }
    }
    class Tuple{
        int key;
        int value;
        Tuple(int k, int v){
            key = k;
            value = v;
        }
    }

    public long getMinimum(int[][] edges, int a, int b, int n){
        boolean[][] visited = new boolean[1024][1024];
        Map<Integer, List<Tuple>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int[] ei: edges){
            int i = ei[0] - 1;
            int j = ei[1] - 1;
            List<Tuple> current = adj.computeIfAbsent(i, k -> new ArrayList<>());
            current.add(new Tuple(j, ei[2]));
            current = adj.computeIfAbsent(j, k -> new ArrayList<>());
            current.add(new Tuple(i, ei[2]));
        }
        TreeSet<Node> q = new TreeSet<>();
        q.add(new Node(a - 1, 0));
        while(!q.isEmpty()){
            Node current = q.pollFirst();
            if(current == null || visited[current.x][current.t]){
                continue;
            }
            visited[current.x][current.t] = true;
            if(current.x == b - 1){
                return current.t;
            }
            List<Tuple> tuples = adj.get(current.x);
            for(Tuple t: tuples){
                int value = t.value;
                int key = t.key;
                int nextValue = current.t | value;
                if(value > 0){
                    q.add(new Node(key, nextValue));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args){
        MinimumPenalty obj = new MinimumPenalty();
        System.out.println(obj.getMinimum(new int[][]{
                        {1, 2, 1},
                        {1, 2, 1000},
                {2, 3, 3},
                {1, 3, 100}
        }, 1, 3, 3));
    }
}
