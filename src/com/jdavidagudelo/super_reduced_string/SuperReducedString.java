package com.jdavidagudelo.super_reduced_string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SuperReducedString {
    public String smallestString(String s){
        Stack<String> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            String current = s.substring(i, i + 1);
            String v = null;
            if(!stack.isEmpty()) {
                v = stack.peek();
            }
            if(current.equals(v)){
                stack.pop();
            }
            else{
                stack.push(current);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(String v: stack){
            sb.append(v);
        }
        return sb.length() == 0? "Empty String": sb.toString();
    }
    public static void main(String[] args){
        SuperReducedString obj = new SuperReducedString();
        System.out.println(obj.smallestString("aaabccddd"));
        System.out.println(obj.smallestString("aa"));
        System.out.println(obj.smallestString("baab"));
    }
}
