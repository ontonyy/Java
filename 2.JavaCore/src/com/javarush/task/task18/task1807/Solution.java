package com.javarush.task.task18.task1807;

import java.io.*;
import java.util.Arrays;

/* 
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        int count = 0;

        try (FileInputStream fileReader = new FileInputStream(fileName)) {
            while (fileReader.available() > 0) {
                if (fileReader.read() == (int) ',') count += 1;
            }
        }
        System.out.println(count);
    }
}
