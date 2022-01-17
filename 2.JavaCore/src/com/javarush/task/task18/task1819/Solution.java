package com.javarush.task.task18.task1819;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/* 
Объединение файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName2));
             BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1))) {
            while (reader.ready()) {
                writer.write(reader.readLine());
            }
            while (reader1.ready()) {
                writer.write(reader1.readLine());
            }
        }
    }
}
