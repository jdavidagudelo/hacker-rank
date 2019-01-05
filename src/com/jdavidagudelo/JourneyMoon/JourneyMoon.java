package com.jdavidagudelo.JourneyMoon;

import java.util.*;

public class JourneyMoon {
    boolean[] visited;
    public int dfs(int n, Map<Integer, List<Integer>> adj, int i){
        int count = 0;
        Stack<Integer> q = new Stack<>();
        q.push(i);
        while (!q.isEmpty()){
            int current = q.pop();
            if(visited[current]){
                continue;
            }
            count += 1;
            visited[current] = true;
            List<Integer> vertices = adj.get(current);
            for(int v: vertices){
                q.push(v);
            }
        }
        return count;
    }
    public long count(int n, int[][] data){
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i < n; i++){
            adj.put(i, new ArrayList<>());
        }
        for (int[] datum : data) {
            List<Integer> current = adj.computeIfAbsent(datum[0], k -> new ArrayList<>());
            current.add(datum[1]);
            current = adj.computeIfAbsent(datum[1], k -> new ArrayList<>());
            current.add(datum[0]);
        }
        visited = new boolean[n];
        long result = 0;
        int valuesSum = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                int newValue = dfs(n, adj, i);
                result = result + valuesSum * newValue;
                valuesSum += newValue;
            }
        }
        return result;
    }
    public static void main(String[] args){
        JourneyMoon obj = new JourneyMoon();
        System.out.println(obj.count(5, new int[][]{
                {0, 1},
                {2, 3},
                {0, 4}
        }));
        System.out.println(obj.count(4, new int[][]{
                {0, 2},
        }));
        System.out.println(obj.count(100000, new int[][]{
                {1, 2},
                {3, 4}
        }));
    }
}
