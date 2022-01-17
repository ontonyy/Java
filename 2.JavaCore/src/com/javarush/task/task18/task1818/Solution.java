package com.javarush.task.task18.task1818;

import java.io.*;
import java.util.Scanner;

/* 
Два в одном
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        String fileName1 = scanner.nextLine();
        String fileName2 = scanner.nextLine();
        String fileName3 = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName1, true));
            BufferedReader reader = new BufferedReader(new FileReader(fileName2));
            BufferedReader reader1 = new BufferedReader(new FileReader(fileName3))) {
            while (reader.ready()) {
                writer.write(reader.read());
            }
            while (reader1.ready()) {
                writer.write(reader1.read());
            }
        }
    }
}
