package com.javarush.task.task18.task1817;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* 
Пробелы
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        int allChars = 0;
        int spaces = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                char c = (char) reader.read();
                if (c == ' ') spaces++;
                allChars++;
            }
        }
        double computing = (double) spaces / allChars * 100;
        System.out.printf("%.2f", computing);
    }
}
