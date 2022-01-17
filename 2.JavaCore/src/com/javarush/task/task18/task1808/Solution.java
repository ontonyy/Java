package com.javarush.task.task18.task1808;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/* 
Разделение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String firstFile = scanner.nextLine();
        String secondFile = scanner.nextLine();
        String thirdFile = scanner.nextLine();

        try (FileInputStream fileInputStream = new FileInputStream(firstFile);
             FileOutputStream fileOutputStream1 = new FileOutputStream(secondFile);
             FileOutputStream fileOutputStream2 = new FileOutputStream(thirdFile)) {

            int halfOfFile = (fileInputStream.available() + 1) / 2;
            int numberOfByte = 0;
            while (fileInputStream.available() > 0) {
                if (numberOfByte < halfOfFile) {
                    fileOutputStream1.write(fileInputStream.read());
                    numberOfByte++;
                } else fileOutputStream2.write(fileInputStream.read());
            }
        }
    }
}
