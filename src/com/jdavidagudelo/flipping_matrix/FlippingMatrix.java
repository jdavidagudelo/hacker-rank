package com.jdavidagudelo.flipping_matrix;

public class FlippingMatrix {

    public static int getMaximum(int[][] matrix){
        int n = matrix.length / 2;
        int sum = 0;
        for(int x = 0; x < n; x++){
            for(int y = 0; y < n; y++){
                sum += Math.max(matrix[x][y],
                        Math.max(matrix[x][2 * n - 1 - y],
                                Math.max(matrix[2 * n - 1 - x][y], matrix[2 * n - x - 1][2 * n - y - 1])));
            }
        }
        return sum;
    }

    public static void main(String[] args){

    }
}
