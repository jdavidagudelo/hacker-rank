package com.jdavidagudelo.halloween_sale;

public class HalloweenSale {

    public int getGames(int p, int d, int m, int s){
        int totalCost = 0;
        int cost = p;
        int count = 0;
        while(cost > m){
            totalCost += cost;
            count += 1;
            cost -= d;
            if(totalCost >= s){
                return count - 1;
            }
        }
        return count + (s - totalCost) / m;
    }

    public static void main(String[] args){
        HalloweenSale obj = new HalloweenSale();
        int result = obj.getGames(20, 3, 6, 80);
        System.out.println(result);
        result = obj.getGames(20, 3,6, 85);
        System.out.println(result);
        result = obj.getGames(100, 1, 1, 99);
        System.out.println(result);
        result = obj.getGames(100, 19, 1, 180);
        System.out.println(result);
        result = obj.getGames(100, 12, 55, 95);
        System.out.println(result);
        result = obj.getGames(100, 11, 10, 1);
        System.out.println(result);
    }
}
