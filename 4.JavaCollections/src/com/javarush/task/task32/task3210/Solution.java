package com.javarush.task.task32.task3210;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

/* 
Используем RandomAccessFile
*/

public class Solution {
    public static void main(String... args) {
        try (RandomAccessFile raf = new RandomAccessFile(args[0], "rw")) {
            byte[] readString = new byte[args[2].length()];
            raf.seek(Long.parseLong(args[1]));
            raf.read(readString, 0, args[2].length());
            raf.seek(raf.length());
            if (args[2].equals(new String(readString))) {
                raf.write("true".getBytes());
            } else {
                raf.write("false".getBytes());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
