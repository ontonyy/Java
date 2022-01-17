package com.javarush.task.task14.task1420;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
НОД
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int firstNum = scanner.nextInt();
        int secondNum = scanner.nextInt();
        int delimiter = 0;
        for (int i = 1; i < Math.max(firstNum, secondNum); i++) {
            if (((firstNum % i == 0 && firstNum >= i) && (secondNum % i == 0 && secondNum >= i)) && (i > delimiter)) {
                delimiter = i;
            }
        }
        System.out.println(delimiter);
    }
}
