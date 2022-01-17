package com.javarush.task.task18.task1820;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 
Округление чисел
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2));
            BufferedReader reader = new BufferedReader(new FileReader(fileName1))) {
            while (reader.ready()) {
                ArrayList<String> nums = new ArrayList<>(Arrays.asList(reader.readLine().split(" ")));
                for (String num: nums) {
                    double number = Double.parseDouble(num);
                    long roundedNum = Math.round(number);
                    writer.write(roundedNum + " ");
                }
            }
        }
    }
}
