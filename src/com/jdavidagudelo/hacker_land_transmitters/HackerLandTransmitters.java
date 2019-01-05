package com.jdavidagudelo.hacker_land_transmitters;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class HackerLandTransmitters {

    int getMinimumCost(int[] data, int k){
        Arrays.sort(data);
        int numOfTransmitters = 0;
        int n = data.length;
        int i = 0;
        while (i < n) {
            numOfTransmitters++;
            int loc = data[i] + k;
            while (i < n && data[i] <= loc) i++;
            loc = data[--i] + k;
            while (i < n && data[i] <= loc) i++;
        }
        return numOfTransmitters;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        HackerLandTransmitters obj = new HackerLandTransmitters();
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("test.text"));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] x = new int[n];

        String[] xItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int xItem = Integer.parseInt(xItems[i]);
            x[i] = xItem;
        }

        int result = obj.getMinimumCost(x, k);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
