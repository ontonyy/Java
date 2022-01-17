package com.javarush.task.task13.task1319;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        String userInput = scanner.nextLine();
        while (!userInput.equals("exit")) {
            writer.write("\n" + userInput);
            userInput = scanner.nextLine();
        }
        writer.write("\n" + userInput);
        writer.close();
    }
}
