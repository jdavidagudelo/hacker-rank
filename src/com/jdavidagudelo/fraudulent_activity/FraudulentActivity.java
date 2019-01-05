package com.jdavidagudelo.fraudulent_activity;

import java.util.*;

public class FraudulentActivity {
    private static float getMedian(int[] freq,int d) {
        if (d % 2 == 1) {
            int center = 0;
            for (int i = 0; i < freq.length; i++) {
                center = center + freq[i];

                if (center > d / 2) {
                    return i;
                }
            }
        } else {
            int count = 0;
            int first = -1;
            int second = -1;
            for (int i = 0; i < freq.length; i++) {
                count = count + freq[i];

                if (count == d / 2) {
                    first = i;
                } else if (count > d / 2) {
                    if (first < 0) first = i;
                    second = i;

                    return ((float) first + (float) second) / 2;
                }
            }
        }
        return 0;
    }

    public int getExpenditure(int[] data, int d){
        int[] freq = new int[201];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;
        for(int i = 0; i < data.length; i++){
            while(i < d){
                freq[data[i]]++;
                q.add(data[i]);
                i++;
            }
            float median = getMedian(freq,d);

            if(data[i] >= 2*median)
            {
                count++;
            }


            // removing outing going element freq
            int elem = q.remove();
            freq[elem] = freq[elem] - 1;

            // adding incoming element to freq
            q.add(data[i]);
            freq[data[i]] = freq[data[i]] + 1;
        }
        return count;
    }

    public static void main(String[] args){
        FraudulentActivity obj = new FraudulentActivity();

    }
}
