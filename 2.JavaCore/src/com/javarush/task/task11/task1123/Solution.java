package com.javarush.task.task11.task1123;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair result = getMinimumMaximumPair(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The maximum is " + result.y);
    }

    public static Pair getMinimumMaximumPair(int[] inputArray) {
        if (inputArray == null || inputArray.length == 0) {
            return new Pair(null, null);
        } else {
            int max = inputArray[0];
            int min = inputArray[1];
            for (Integer number: inputArray) {
                if (number > max) {
                    max = number;
                } else if (number < min) {
                    min = number;
                }
            }
            return new Pair(min, max);
        }
    }

    public static class Pair {
        public Integer x;
        public Integer y;

        public Pair(Integer x, Integer y) {
            this.x = x;
            this.y = y;
        }
    }
}
