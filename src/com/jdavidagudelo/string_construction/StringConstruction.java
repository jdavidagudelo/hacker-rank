package com.jdavidagudelo.string_construction;

import java.util.HashSet;

public class StringConstruction {
    public int getMinCost(String s) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            set.add(s.substring(i, i + 1));
        }
        return set.size();
    }
    public static void main(String[] args){
        StringConstruction obj = new StringConstruction();
        System.out.println(obj.getMinCost("abcd"));
        System.out.println(obj.getMinCost("abab"));
    }
}
