package net.clovermen.coding.contest;

public class Fibonacci {

    public static void main(String[] args) {

        int n = 38;

        long previous = 0;
        long actual = 1;


        for(int i = 0; i < n - 1; i++) {

            long interim = previous + actual;
            previous = actual;
            actual = interim;
        }

        System.out.println(actual);

    }
}
