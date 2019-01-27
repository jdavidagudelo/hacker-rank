package com.jdavidagudelo.rust_murderer;

import java.util.*;

public class RustMurderer {

    class Node implements Comparable<Node>{
        int v;
        int w;
        Node(int i, int t){
            v = i;
            w = t;
        }

        @Override
        public int compareTo(Node node) {
            if(w != node.w){
                return Integer.compare(w, node.w);
            }
            return Integer.compare(v, node.v);
        }
    }
    public int[] bfs(Map<Integer, Set<Integer>> adj, int n, int start){
        boolean[] visited = new boolean[n];
        TreeSet<Node> q = new TreeSet<>();
        Integer[] set = new Integer[n];
        for(int i = 0; i < n; i++){
            set[i] = i;
        }
        int[] result = new int[n - 1];
        q.add(new Node(start, 0));
        while(!q.isEmpty()){
            Node current = q.pollFirst();
            if(current == null || visited[current.v]){
                continue;
            }
            visited[current.v] = true;
            if(current.v > start) {
                result[current.v - 1] = current.w;
            }
            else if(current.v < start){
                result[current.v] = current.w;
            }
            Set<Integer> cSet = adj.get(current.v);
            Set<Integer> cp = new HashSet<>(Arrays.asList(set));
            cp.removeAll(cSet);
            for(Integer v: cp){
                q.add(new Node(v, current.w + 1));

            }
        }
        return result;
    }

    public int[] getResult(Map<Integer, Set<Integer>> adj, int n, int start){
        Set<Integer> notVisited = adj.get(start);
        Set<Integer> newlyVisited = new HashSet<>();
        int currentDistance = 2;
        int[] result = new int[n - 1];
        Arrays.fill(result, 1);
        while(!notVisited.isEmpty()){
            for(Integer v: notVisited){
                Set<Integer> diff = new HashSet<>(notVisited);
                diff.addAll(adj.get(v));
                if(diff.size() < n){
                    if(v > start) {
                        result[v - 1] = currentDistance;
                    }
                    else if(v < start){
                        result[v] = currentDistance;
                    }
                    newlyVisited.add(v);
                }
            }
            notVisited.removeAll(newlyVisited);
            newlyVisited = new HashSet<>();
            currentDistance += 1;
        }
        return result;
    }

    public int[] getMinDistances(int[][] roads, int n, int s){
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new HashSet<>());
        }
        for(int i = 0; i < roads.length; i++){
            int x = roads[i][0] - 1;
            int y = roads[i][1] - 1;
            Set<Integer> current = adj.get(x);
            current.add(y);
            current = adj.get(y);
            current.add(x);
        }
        return getResult(adj, n, s - 1);
    }

    public static void main(String[] args){
        RustMurderer obj = new RustMurderer();
        int[][] roads = new int[][]{
                {1, 2},
                {2, 3},
                {1, 4}
        };
        System.out.println(Arrays.toString(obj.getMinDistances(roads, 4, 1)));
        roads = new int[][]{
                {1, 2},
                {2, 3}
        };
        System.out.println(Arrays.toString(obj.getMinDistances(roads, 4, 2)));
    }
}
