package com.jdavidagudelo.maximum_perimeter_triangle;

import java.util.Arrays;

public class MaximumPerimeterTriangle {

    public long[] getMaximumPerimeter(int[] sticks){
        Arrays.sort(sticks);
        long max = 0;
        long bigestSide = 0;
        long minimumBigestSide = 0;
        long[] maxTriagle = null;
        for(int i = sticks.length - 1; i >= 0; i--){
            for(int j = i - 1; j >= 0; j--){
                for(int k = j - 1; k >= 0; k--){
                    long a = sticks[i];
                    long b = sticks[j];
                    long c = sticks[k];
                    if(a + b > c && b + c > a && a + c > b){
                        if(a + b + c > max) {
                            bigestSide = Math.max(Math.max(a, b), c);
                            minimumBigestSide = Math.min(Math.min(a, b), c);
                            maxTriagle = new long[]{a, b, c};
                            max = a + b + c;
                        }
                        else if(a + b + c == max) {
                            if(Math.max(Math.max(a, b), c) > bigestSide){
                                bigestSide = Math.max(Math.max(a, b), c);
                                minimumBigestSide = Math.min(Math.min(a, b), c);
                                maxTriagle = new long[]{a, b, c};
                            }
                            else if(Math.min(Math.min(a, b), c) > minimumBigestSide){
                                minimumBigestSide = Math.min(Math.min(a, b), c);
                                maxTriagle = new long[]{a, b, c};
                            }
                        }
                    }
                }
            }
        }
        if(maxTriagle != null){
            Arrays.sort(maxTriagle);
        }
        return maxTriagle;
    }

    public static void main(String[] args){
        MaximumPerimeterTriangle obj = new MaximumPerimeterTriangle();
        System.out.println(Arrays.toString(obj.getMaximumPerimeter(new int[]{1, 1, 1, 3, 3})));
        System.out.println(Arrays.toString(obj.getMaximumPerimeter(new int[]{1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000
        })));
    }
}
