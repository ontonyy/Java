package com.javarush.task.task19.task1915;

import java.io.*;
import java.util.Scanner;

/* 
Дублируем текст
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintStream defaultPrintStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream newPrintStream = new PrintStream(byteArrayOutputStream);
        System.setOut(newPrintStream);

        testString.printSomething();

        System.setOut(defaultPrintStream);
        String result = byteArrayOutputStream.toString();
        try (FileOutputStream out = new FileOutputStream(fileName)) {
            for (int i = 0; i < result.length(); i++) {
                out.write((int) result.charAt(i));
            };
        }
        System.out.println(result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

