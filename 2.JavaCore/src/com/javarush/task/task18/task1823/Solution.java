package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName;
        while (!(fileName = scanner.nextLine()).equals("exit")) {
            new ReadThread(fileName);
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            int[] charBytes = new int[256];
            int maxByte = 0;
            int maxCount = 0;
            try (BufferedReader reader = new BufferedReader(new FileReader(this.fileName))) {
                while (reader.ready()) {
                    charBytes[reader.read()]++;
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            for (int i = 0; i < charBytes.length; i++) {
                if (charBytes[i] > maxCount) {
                    maxCount = charBytes[i];
                    maxByte = i;
                }
            }
            resultMap.put(fileName, maxByte);
        }
    }
}
