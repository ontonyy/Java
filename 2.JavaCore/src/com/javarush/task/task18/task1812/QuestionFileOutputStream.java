package com.javarush.task.task18.task1812;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/* 
Расширяем AmigoOutputStream
*/

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream amigo;
    public QuestionFileOutputStream(AmigoOutputStream stream) {
        this.amigo = stream;
        }

    @Override
    public void flush() throws IOException {
        this.amigo.flush();
    }

    @Override
    public void write(int b) throws IOException {
        this.amigo.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        this.amigo.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        this.amigo.write(b, off, len);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        String response = new Scanner(System.in).nextLine();
        if (response.equals("Д")) {
            this.amigo.close();
        }
    }
}

