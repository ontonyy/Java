package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword(){
        char[] letters = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        Random randNum = new Random();
        String password = "";
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        password += randNum.nextInt(10);
        password += letters[randNum.nextInt(letters.length)];
        password += String.valueOf(letters[randNum.nextInt(letters.length)]).toUpperCase();
        for (int i = 0; i < 5; i++) {
            String[] randoms = {Integer.toString(randNum.nextInt(10)),
                    String.valueOf(letters[randNum.nextInt(letters.length)]),
                    String.valueOf(letters[randNum.nextInt(letters.length)]).toUpperCase()};
            password += randoms[randNum.nextInt(3)];
        }
        try {
            byteOut.write(password.getBytes());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return byteOut;
    }
}
