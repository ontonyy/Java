package com.javarush.task.task13.task1326;

import java.io.*;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        Scanner scanner1 = new Scanner(new FileInputStream(fileName));
        List<Integer> data = new ArrayList<>();

        while (scanner1.hasNext()) {
            int value = scanner1.nextInt();
            if (value % 2 == 0 ) data.add(value);
        }

        Collections.sort(data);
        for (int number:data) {
            System.out.println(number);
        }
        scanner1.close();
    }
}
