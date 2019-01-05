package com.jdavidagudelo.ice_cream_parlor;


import java.util.*;

public class IceCreamParlor {
    public int binarySearch(int[] data, int v){
        int start = 0;
        int end = data.length - 1;
        while(start <= end){
            int mid = (end + start) / 2;
            if(data[mid] > v){
                end = mid - 1;
            }
            else if (data[mid] < v){
                start = mid + 1;
            }
            else{
                return mid;
            }
        }
        return -1;
    }
    public int[] iceCreamParlor(int m, int[] data){
        int[] result = new int[2];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < data.length; i++){
            List<Integer> current = map.computeIfAbsent(data[i], k -> new ArrayList<>());
            current.add(i);
        }
        Arrays.sort(data);
        for (int datum : data) {
            int s = m - datum;
            List<Integer> current = map.get(s);
            if (s == datum) {
                if (current.size() > 1) {
                    result[0] = current.get(0) + 1;
                    result[1] = current.get(1) + 1;
                    Arrays.sort(result);
                    return result;
                }
            } else {
                int index = binarySearch(data, s);
                if (index >= 0) {
                    result[0] = map.get(datum).get(0) + 1;
                    result[1] = map.get(data[index]).get(0) + 1;
                    Arrays.sort(result);
                    return result;
                }
            }
        }
        return null;
    }

    public static void main(String[] args){
        IceCreamParlor obj = new IceCreamParlor();
        System.out.println(Arrays.toString(obj.iceCreamParlor(4, new int[]{1, 4, 5, 3, 2})));
        System.out.println(Arrays.toString(obj.iceCreamParlor(4, new int[]{2, 2, 4, 3})));


        System.out.println(Arrays.toString(obj.iceCreamParlor(9, new int[]{1, 3, 4, 6, 7, 9})));
        System.out.println(Arrays.toString(obj.iceCreamParlor(8, new int[]{1, 3, 4, 4, 6, 8})));
        System.out.println(Arrays.toString(obj.iceCreamParlor(100, new int[]{5, 75, 25})));
    }
}
