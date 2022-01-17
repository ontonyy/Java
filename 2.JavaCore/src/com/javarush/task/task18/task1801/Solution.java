package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int maxByte = 0;
        try (FileInputStream in = new FileInputStream(fileName)) {
            while (in.available() > 0) {
                int currByte = in.read();
                if (currByte > maxByte) maxByte = currByte;
            }
            System.out.println(maxByte);
        }
    }
}
