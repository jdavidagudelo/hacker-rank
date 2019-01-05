package com.jdavidagudelo.grid_land_metro;

import java.util.*;

public class GridLandMetro {

    static class Interval implements Comparable<Interval>{
        int start;
        int end;
        Interval(int s, int e){
            start = s;
            end = e;
        }

        static Stack<Interval> mergeIntervals(List<Interval> intervals){
            Collections.sort(intervals);
            Stack<Interval> stack = new Stack<>();
            stack.push(intervals.get(0));
            for(int i = 1; i < intervals.size(); i++){
                Interval current = stack.pop();
                Interval interval = intervals.get(i);
                if(interval.start <= current.end){
                    current.end = Math.max(interval.end, current.end);
                    stack.push(current);
                }
                else{
                    stack.push(current);
                    stack.push(interval);
                }
            }
            return stack;
        }

        @Override
        public int compareTo(Interval interval) {
            if(start != interval.start){
                return Integer.compare(start, interval.start);
            }
            return Integer.compare(end, interval.end);
        }
        public String toString(){
            return "(" + start + ", " + end + ")";
        }
    }

    public long getLampsNumber(long n, long m, int k, int[][] tracks){
        Map<Integer, List<Interval>> map = new HashMap<>();
        for(int i = 0; i < k; i++){
            List<Interval> current = map.computeIfAbsent(tracks[i][0] - 1, v  -> new ArrayList<>());
            current.add(new Interval(tracks[i][1] - 1, tracks[i][2] - 1));
        }
        long result = m * n;
        for(List<Interval> intervals: map.values()){
            Stack<Interval> merged = Interval.mergeIntervals(intervals);
            for(Interval interval: merged){
                result -= (interval.end - interval.start + 1);
            }
        }
        return result;
    }

    public static void main(String[] args){
        GridLandMetro obj = new GridLandMetro();
        int[][] tracks = new int[][]{
                {2, 2, 3},
                {3, 1, 4},
                {4, 4, 4}
        };

        System.out.println(obj.getLampsNumber(4, 4, 3, tracks));
        tracks = new int[][]{
                {2, 1, 5},
                {2, 2, 4},
                {2, 8, 8}
        };
        System.out.println(obj.getLampsNumber(2, 9, 3, tracks));
    }
}
