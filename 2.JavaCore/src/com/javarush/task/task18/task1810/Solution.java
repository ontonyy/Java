package com.javarush.task.task18.task1810;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
DownloadException
*/

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String fileName = scanner.nextLine();
            try (FileInputStream in = new FileInputStream(fileName)) {
                if (in.available() >= 1000) {
                    System.out.println("Work...");
                } else {
                    throw new DownloadException();
                }
            }
        }
    }

    public static class DownloadException extends Exception {

    }
}
