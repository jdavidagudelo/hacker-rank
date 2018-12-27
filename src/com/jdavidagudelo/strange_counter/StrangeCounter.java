package com.jdavidagudelo.strange_counter;

public class StrangeCounter {
    public int getCounterValue(int t){
        int x = 3;
        while(t > x){
            t = t - x;
            x *= 2;
        }
        return x - t + 1;
    }
    public static void main(String[] args){
        StrangeCounter obj = new StrangeCounter();
        System.out.println(obj.getCounterValue(1));
        System.out.println(obj.getCounterValue(2));
        System.out.println(obj.getCounterValue(3));
        System.out.println(obj.getCounterValue(4));
        System.out.println(obj.getCounterValue(5));
        System.out.println(obj.getCounterValue(6));
        System.out.println(obj.getCounterValue(7));
        System.out.println(obj.getCounterValue(8));
        System.out.println(obj.getCounterValue(9));
        System.out.println(obj.getCounterValue(10));
        System.out.println(obj.getCounterValue(11));
        System.out.println(obj.getCounterValue(12));
        System.out.println(obj.getCounterValue(13));
        System.out.println(obj.getCounterValue(14));
        System.out.println(obj.getCounterValue(15));
        System.out.println(obj.getCounterValue(16));
        System.out.println(obj.getCounterValue(17));
        System.out.println(obj.getCounterValue(18));
        System.out.println(obj.getCounterValue(19));
        System.out.println(obj.getCounterValue(20));
        System.out.println(obj.getCounterValue(21));
        System.out.println(obj.getCounterValue(22));
        System.out.println(obj.getCounterValue(23));
        System.out.println(obj.getCounterValue(24));
        System.out.println(obj.getCounterValue(25));
    }
}
