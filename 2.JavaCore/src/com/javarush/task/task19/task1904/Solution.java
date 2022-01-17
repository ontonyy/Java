package com.javarush.task.task19.task1904;

import javax.swing.text.DateFormatter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String personLine = fileScanner.nextLine();
            String[] splitted = personLine.split(" ");
            String firstName = splitted[1];
            String middleName = splitted[2];
            String lastName = splitted[0];
            Calendar calendar = new GregorianCalendar(Integer.parseInt(splitted[5]), Integer.parseInt(splitted[4]) - 1, Integer.parseInt(splitted[3]));
            Date date = calendar.getTime();
            return new Person(firstName, middleName, lastName, date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
