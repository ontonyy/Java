package com.javarush.task.task33.task3308;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData = new String[]{"String1", "String2", "String3", "String4", "String5", "String \"6\"", "String & 7", "String <8>", ""};

    static class Goods {
        List<String> names = new ArrayList<>();
    }
}
