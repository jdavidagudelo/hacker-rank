package com.jdavidagudelo.highest_value_palindrome;

import java.util.HashSet;
import java.util.Set;

public class HighestValuePalindrome {
    public String getMaxPalindrome(String s, int k){
        int start = 0;
        int end = s.length();
        int[] result = new int[s.length()];
        Set<Integer> used = new HashSet<>();
        while(start < end){
            int startValue = Integer.parseInt(s.substring(start, start + 1));
            int endValue = Integer.parseInt(s.substring(end - 1, end));
            if(startValue != endValue){
                if(k == 0){
                    return "-1";
                }
                used.add(start);
                startValue = Math.max(startValue, endValue);
                endValue = startValue;
                k -= 1;
            }
            result[start] = startValue;
            result[end - 1] = endValue;
            start += 1;
            end -= 1;
        }
        start = 0;
        end = s.length();

        while(start < end){
            int startValue = result[start];
            if((used.contains(start) || end - start == 1) && k > 0 && startValue != 9){
                k -= 1;
                result[start] = 9;
                result[end - 1] = 9;
            }
            else if(k > 1 && startValue != 9){
                k -= 2;
                result[start] = 9;
                result[end - 1] = 9;
            }
            start += 1;
            end -= 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int v: result){
            sb.append(v);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        HighestValuePalindrome obj = new HighestValuePalindrome();
        System.out.println(obj.getMaxPalindrome("3943", 1));
        System.out.println(obj.getMaxPalindrome("092282", 3));
        System.out.println(obj.getMaxPalindrome("0011", 1));
        System.out.println(obj.getMaxPalindrome("5", 1));
    }
}
