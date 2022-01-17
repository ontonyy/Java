package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
    static SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

    public static void main(String[] args) throws ParseException {
        String newDate;
        if (args[0] == "-c") {
            Date birthdayDate = simpleDateFormat.parse(args[3]);
            if (args[2] == "ж") {
                allPeople.add(Person.createFemale(args[1], birthdayDate));
            } else if (args[2] == "м") {
                allPeople.add(Person.createMale(args[1], birthdayDate));
            }
            System.out.println(allPeople.size() - 1);
        } else if (args[0] == "-r") {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            newDate = simpleDateFormat2.format(person.getBirthDate());
            System.out.println(person.getName() + " " + (person.getSex() == Sex.MALE ? "м" : "ж") + " " + newDate);
        } else if (args[0] == "-u") {
            int id = Integer.parseInt(args[1]);
            Person person = allPeople.get(id);
            person.setBirthDate(simpleDateFormat.parse(args[4]));
            person.setName(args[2]);
            person.setSex(getSex(args[3]));
            allPeople.set(id, person);
        } else if (args[0] == "-d") {
            Person currentPerson = allPeople.get(Integer.parseInt(args[1]));
            currentPerson.setName(null);
            currentPerson.setSex(null);
            currentPerson.setBirthDate(null);
        }
    }

    private static Sex getSex(String sexParam) {
        return sexParam.equals("м") ? Sex.MALE : Sex.FEMALE;
    }
}
