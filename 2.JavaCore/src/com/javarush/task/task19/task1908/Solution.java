package com.javarush.task.task19.task1908;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileName1;
        String fileName2;

        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = bufferedReader.readLine();
            fileName2 = bufferedReader.readLine();
        }

        StringBuilder text = new StringBuilder();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName1))) {
            while (fileReader.ready()) {
                text.append((char) fileReader.read());
            }
        }
        String[] listReaded = text.toString().split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String str: listReaded) {
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    count++;
                }
            }
            if (count == str.length()) {
                list.add(str);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            for (String str: list) {
                writer.write(str + " ");
            }
        }

    }
}
