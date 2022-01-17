package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();
    public static String firstFileName;
    public static String secondFileName;

    static {
        Scanner scanner = new Scanner(System.in);
        firstFileName = scanner.nextLine();
        secondFileName = scanner.nextLine();
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader1 = new FileReader(firstFileName);
        FileReader fileReader2 = new FileReader(secondFileName);
        BufferedReader reader = new BufferedReader(fileReader1);
        String s;
        while ((s = reader.readLine()) != null) {
            allLines.add(s);
        }
        reader = new BufferedReader(fileReader2);
        while ((s = reader.readLine()) != null) {
            forRemoveLines.add(s);
        }
        reader.close();
        new Solution().joinData();
    }

    public void joinData() throws IOException {
        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        } else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
