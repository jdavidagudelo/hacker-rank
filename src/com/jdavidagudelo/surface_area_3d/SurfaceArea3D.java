package com.jdavidagudelo.surface_area_3d;

public class SurfaceArea3D {
    public int getArea(int W, int H, int[][] A){
        int area = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                area += 4 * A[i][j] + 2;
                area -= 2 * Math.min(A[i][j], A[i+1][j]);
                area -= 2 * Math.min(A[i][j], A[i][j+1]);
            }
        }
        return area;
    }
    public static void main(String[] args){
        SurfaceArea3D obj = new SurfaceArea3D();
        System.out.println(obj.getArea(1, 1, new int[][]{{1, 0}, {0, 0}}));
        System.out.println(obj.getArea(3, 3, new int[][]{
                {1, 3, 4, 0},
                {2, 2, 3, 0},
                {1, 2, 4, 0},
                {0, 0, 0, 0}
        }));
    }
}
