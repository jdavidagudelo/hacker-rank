package com.jdavidagudelo.cut_tree;

import java.util.*;

public class CutTree {

    public int dfs(int u, int parent, int totalSum, Map<Integer, List<Integer>> adj, int[] subtree, int res){
        int sum = subtree[u];
        List<Integer> current = adj.get(u);
        for(int v: current){
            if(v != parent){
                res = dfs(v, u, totalSum, adj, subtree, res);
                sum += subtree[v];
            }
        }
        subtree[u] = sum;
        if (u != 0 && Math.abs(totalSum - 2*sum) < res) {
            res = Math.abs(totalSum - 2 * sum);
        }
        return res;
    }
    public int solve(List<Integer> data, List<List<Integer>> edges){
        int n = data.size();
        int totalSum = 0;
        int[] subtree = new int[n];
        for(int i = 0; i < data.size(); i++){
            subtree[i] = data.get(i);
            totalSum += data.get(i);
        }
        Map<Integer, List<Integer>> adj = new HashMap<>(n);
        for(List<Integer> d: edges){
            List<Integer> current = adj.computeIfAbsent(d.get(0) - 1, k -> new ArrayList<>());
            current.add(d.get(1) - 1);
            current = adj.computeIfAbsent(d.get(1) - 1, k -> new ArrayList<>());
            current.add(d.get(0) - 1);
        }
        return dfs(0, -1, totalSum, adj, subtree, Integer.MAX_VALUE);
    }
    public static void main(String[] args){
        CutTree obj = new CutTree();
        List<Integer> data = Arrays.asList(100, 200, 100, 500, 100, 600);
        List<List<Integer>> edges = Arrays.asList(Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(2, 5),
                Arrays.asList(4, 5),
                Arrays.asList(5, 6));
        System.out.println(obj.solve(data, edges));
    }
}
