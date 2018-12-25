package com.jdavidagudelo.beutiful_triplets;

public class BeautifulTriplets {
    public int getBeautifulTriplets(int[] a, int d){
        int n = a.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                if(a[j] - a[i] == d) {
                    for (int k = j + 1; k < n; k++) {
                        if (a[k] - a[j] == d) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] data = {1, 2, 4, 5, 7, 8, 10};
        int d = 3;
        BeautifulTriplets obj = new BeautifulTriplets();
        int result = obj.getBeautifulTriplets(data, d);
        System.out.println(result);
    }
}
