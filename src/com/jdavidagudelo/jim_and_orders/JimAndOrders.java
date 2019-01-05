package com.jdavidagudelo.jim_and_orders;

import java.util.Arrays;

public class JimAndOrders {

    class Order implements Comparable<Order>{
        int order;
        int preparationTime;
        int t;
        int index;
        Order(int o, int p, int i){
            this.preparationTime = p;
            this.order = o;
            this.t = o + p;
            this.index = i;
        }

        @Override
        public int compareTo(Order order) {
            if(this.t != order.t){
                return Integer.compare(this.t, order.t);
            }
            return Integer.compare(this.index, order.index);
        }
    }

    public int[] getOrders(int[][] orders){
        Order[] sorted = new Order[orders.length];
        for(int i = 0; i < orders.length; i++){
            sorted[i] = new Order(orders[i][0], orders[i][1], i + 1);
        }
        Arrays.sort(sorted);
        int[] result = new int[orders.length];
        for(int i = 0; i < sorted.length; i++){
            result[i] = sorted[i].index;
        }
        return result;
    }
    public static void main(String[] args){
        JimAndOrders obj = new JimAndOrders();
        System.out.println(Arrays.toString(obj.getOrders(new int[][]{
                {8, 1},
                {4, 2},
                {5, 6},
                {3, 1},
                {4, 3},
        })));
        System.out.println(Arrays.toString(obj.getOrders(new int[][]{
                {1, 3},
                {2, 3},
                {3, 3}
        })));

    }
}
