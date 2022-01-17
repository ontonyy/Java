package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int minByte = 1000;
        try (FileInputStream in = new FileInputStream(fileName)) {
            while (in.available() > 0) {
                int currByte = in.read();
                if (currByte < minByte) minByte = currByte;
            }
            System.out.println(minByte);
        }
    }
}
