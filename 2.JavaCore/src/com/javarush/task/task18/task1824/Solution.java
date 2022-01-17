package com.javarush.task.task18.task1824;

import java.io.*;
import java.util.Scanner;

/* 
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String fileName = scanner.nextLine();
            try {
                BufferedReader in = new BufferedReader(new FileReader(fileName));
                in.close();
            } catch (IOException exception) {
                System.out.println(fileName);
                break;
            }
        }
    }
}
