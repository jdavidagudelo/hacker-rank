package com.jdavidagudelo.big_sorting;
import java.util.*;

class BigIntegerComparator implements Comparator<String>{
    public int compare(String a, String b){
        if(a.length() == b.length()){
            return a.compareTo(b);
        }
        return Integer.compare(a.length(), b.length());
    }
}

public class BigSorting {

    public String[] sorted(String[] values){
        Arrays.sort(values, new BigIntegerComparator());
        return values;
    }

    public static void main(String[] args){
        BigSorting obj = new BigSorting();
        String[] result = obj.sorted(new String[]{
                "1",
                "2",
                "100",
                "12303479849857341718340192371",
                "3084193741082937",
                "3084193741082938",
                "111",
                "200"});
        System.out.println(Arrays.toString(result));
        String[] result1 = {};
    }
}
