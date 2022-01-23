package com.Ontony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Doctor doctor = new Doctor("Jason", 15);
        ArrayList<String> organList = new ArrayList<>(Arrays.asList("1 - Skin", "2 - Eyes", "3 - Pisja", "4 - Foot", "5 - Brain", "6 - Quit"));
        doctor.greeting();
        Scanner scanner = new Scanner(System.in);
        String choose = "";
        organList.forEach(System.out::println);
        choose = scanner.nextLine();
        while (true) {
            organList.forEach(System.out::println);
            choose = scanner.nextLine();
            if (choose.equals("6")) {
                break;
            }
            System.out.println(doctor.treating(choose));
        }

    }
}
