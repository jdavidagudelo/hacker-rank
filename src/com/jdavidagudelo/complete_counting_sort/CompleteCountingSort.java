package com.jdavidagudelo.complete_counting_sort;

import java.util.ArrayList;
import java.util.List;

public class CompleteCountingSort {
    public String countingSort(List<ArrayList<String>> arr){
        List[] map = new List[100];
        for(int i = 0; i < map.length; i++){
            map[i] = new ArrayList<String>();
        }
        int half = arr.size() / 2 - 1;
        int w = 0;
        for(List<String> v: arr){
            Integer key = Integer.parseInt(v.get(0));
            List<String> current = map[key];
            if(w > half) {
                current.add(v.get(1));
            }
            else {
                current.add("-");
            }
            w += 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 100; i++){
            List<String> data = map[i];
            if(data != null) {
                for(String s: data) {
                    sb.append(s).append(" ");
                }
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){

    }
}
