package com.jdavidagudelo.container_toys;

import java.util.TreeSet;

public class ContainerToys {

    public int getMinContainers(int[] w){
        TreeSet<Integer> set = new TreeSet<>();
        for(int wi: w){
            set.add(wi);
        }
        int count = 0;
        while(!set.isEmpty()){
            Integer v = set.first();
            set.remove(v);
            while(!set.isEmpty() && v + 4 >= set.first()){
                set.remove(set.first());
            }
            count += 1;
        }
        return count;
    }

    public static void main(String[] args){
        ContainerToys obj = new ContainerToys();
        System.out.println(obj.getMinContainers(new int[]{1, 2, 3, 21, 7, 12, 14, 21}));
    }
}
