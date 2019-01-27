package com.jdavidagudelo.jack_goes_rapture;

import java.util.*;

public class JackGoesRapture {

    static class Edge{
        int destination;
        int weight;
        Edge(int d, int w){
            destination = d;
            weight = w;
        }
    }

    static class Node implements Comparable<Node>{
        int v;
        int w;

        Node(int i, int weight){
            v = i;
            w = weight;
        }

        @Override
        public int compareTo(Node node) {
            if(w != node.w){
                return Integer.compare(w, node.w);
            }
            return Integer.compare(v, node.w);
        }
    }

    public static int bfs(Map<Integer, List<Edge>> adj, int start, int end, int n){
        boolean[] visited = new boolean[n];
        TreeSet<Node> q = new TreeSet<>();
        q.add(new Node(start, 0));
        while(!q.isEmpty()){
            Node current = q.pollFirst();
            if(current == null || visited[current.v]){
                continue;
            }
            if(current.v == end){
                return current.w;
            }
            visited[current.v] = true;
            for(Edge edge: adj.get(current.v)){
                Node next = new Node(edge.destination, current.w + Math.max(
                        0, edge.weight - current.w));
                q.add(next);
            }
        }
        return -1;
    }

    public static void getCost(int gNodes, List<Integer> gFrom,
                               List<Integer> gTo, List<Integer> gWeight) {
        int n = gFrom.size();
        Map<Integer, List<Edge>> adj = new HashMap<>();
        for(int i = 0; i < gNodes; i++){
            adj.put(i, new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            int x = gFrom.get(i) - 1;
            int y = gTo.get(i) - 1;
            int w = gWeight.get(i);
            List<Edge> current = adj.get(x);
            current.add(new Edge(y, w));
            current = adj.get(y);
            current.add(new Edge(x, w));
        }
        int result = bfs(adj, 0, gNodes - 1, gNodes);
        if(result >= 0) {
            System.out.println(result);
        }
        else {
            System.out.println("NO PATH EXISTS");
        }
    }

    public static void main(String[] args){

        List<Integer> gFrom = Arrays.asList(1, 3, 1, 4, 2);
        List<Integer> gTo = Arrays.asList(2, 5, 4, 5, 3);
        List<Integer> gWeight = Arrays.asList(60, 70, 120, 150, 80);
        getCost(5, gFrom, gTo, gWeight);

        gFrom = Arrays.asList(1, 2, 3, 4, 1, 3);
        gTo = Arrays.asList(2, 3, 4, 5, 3, 5);
        gWeight = Arrays.asList(30, 50, 70, 90, 70, 85);
        getCost(5, gFrom, gTo, gWeight);

    }
}
