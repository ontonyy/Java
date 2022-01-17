package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException{
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] splitted = reader.readLine().split(" ");
                Calendar data = new GregorianCalendar(
                        Integer.parseInt(splitted[splitted.length - 1]),
                        Integer.parseInt(splitted[splitted.length - 2]) - 1,
                        Integer.parseInt(splitted[splitted.length - 3]));
                if (splitted.length == 4) {
                    PEOPLE.add(new Person(splitted[0], data.getTime()));
                } else if (splitted.length == 5) {
                    PEOPLE.add(new Person(splitted[0] + splitted[1], data.getTime()));
                } else if (splitted.length == 6)  {
                    PEOPLE.add(new Person(String.format("%s %s %s", splitted[0], splitted[1], splitted[2]), data.getTime()));
                }
            }
        }
    }
}
