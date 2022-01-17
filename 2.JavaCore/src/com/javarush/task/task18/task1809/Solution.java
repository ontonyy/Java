package com.javarush.task.task18.task1809;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/* 
Реверс файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String firstFile = scanner.nextLine();
        String secondFile = scanner.nextLine();

        ArrayList<Integer> bytes = new ArrayList<>();
        try (FileInputStream in = new FileInputStream(firstFile);
             FileOutputStream out = new FileOutputStream(secondFile)) {
                 while (in.available() > 0) {
                     bytes.add(in.read());
                 }
                 Collections.reverse(bytes);
            for (int i = 0; i < bytes.size(); i++) {
                out.write(bytes.get(i));
            }
            }
        }
    }
