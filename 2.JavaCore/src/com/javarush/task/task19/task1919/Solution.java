package com.javarush.task.task19.task1919;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/* 
Считаем зарплаты
*/

public class Solution {

    public static void main(String[] args) throws IOException{

        TreeMap<String, Double> nameSalary = new TreeMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] splitted = reader.readLine().split(" ");
                String name = splitted[0];
                Double salary = Double.parseDouble(splitted[1]);
                if (nameSalary.containsKey(name)) {
                    nameSalary.put(name, salary + nameSalary.get(name));
                } else {
                    nameSalary.put(name, salary);
                }
            }
        }
        for (String name: nameSalary.keySet()) {
            System.out.println(name + " " + nameSalary.get(name));
        }
    }
}

