package com.jdavidagudelo.minimum_swaps;

import java.util.*;

public class MinimumSwaps {

    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        Pair(int i, int j){
            x = i;
            y = j;
        }

        @Override
        public int compareTo(Pair pair) {
            if(x != pair.x){
                return Integer.compare(x, pair.x);
            }
            return Integer.compare(y, pair.y);
        }
        public String toString(){
            return "(" + x + ", " + y + ")";
        }
    }

    public static int minSwaps(Integer[] arr)
    {
        int n = arr.length;

        // Create two arrays and use as pairs where first
        // array is element and second array
        // is position of first element
        List<Pair> arrpos = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arrpos.add(new Pair(arr[i], i));
        }

        // Sort the array by array element values to
        // get right position of every element as the
        // elements of second array.
        arrpos.sort(Comparator.naturalOrder());
        // To keep track of visited elements. Initialize
        // all elements as not visited or false.
        Boolean[] vis = new Boolean[n];
        Arrays.fill(vis, false);

        // Initialize result
        int ans = 0;

        // Traverse array elements
        for (int i = 0; i < n; i++)
        {
            // already swapped and corrected or
            // already present at correct pos
            if (vis[i] || arrpos.get(i).y == i)
                continue;

            // find out the number of  node in
            // this cycle and add in ans
            int cycle_size = 0;
            int j = i;
            while (!vis[j])
            {
                vis[j] = true;

                // move to next node
                j = arrpos.get(j).y;
                cycle_size++;
            }

            // Update answer by adding current cycle.
            if(cycle_size > 0)
            {
                ans += (cycle_size - 1);
            }
        }

        // Return result
        return ans;
    }

    public int minSwapsToEqual(Integer[] a, Integer[] b){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < a.length; i++){
            map.put(b[i], i);
        }
        for(int i = 0; i < a.length; i++){
            b[i] = map.get(a[i]);
        }
        return minSwaps(b);
    }
    public int getBeautiful(Integer[] data){
        Integer[] copy = Arrays.copyOf(data, data.length);
        Integer[] b = Arrays.copyOf(data, data.length);
        Arrays.sort(data);
        int result = minSwapsToEqual(data, b);
        Arrays.sort(data, (o, t1) -> Integer.compare(t1, o));
        result = Math.min(result, minSwapsToEqual(data, copy));
        return result;
    }

    public static void main(String[] args){
        MinimumSwaps obj = new MinimumSwaps();
        System.out.println(obj.getBeautiful(new Integer[]{2, 5, 3, 1}));
        System.out.println(obj.getBeautiful(new Integer[]{3, 4, 2, 5, 1}));
    }
}
