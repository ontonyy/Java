package com.javarush.task.task18.task1827;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы
*/

public class Solution {
    public static class Product {
        int id;
        String name;
        String price;
        String quantity;

        public Product(int id, String name, String price, String quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            return;
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        ArrayList<Product> products = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            while (bufferedReader.ready()) {
                Product product = getProduct(bufferedReader.readLine());
                products.add(product);
            }
        }
        if (args[0].equals("-c")) {
            int max_id = 0;
            for (Product pro : products) {
                if (pro.id > max_id) {
                    max_id = pro.id;
                }
            }
            String name = args[1];
            if (name.length() > 30) {
                name = name.substring(0, 30);
            }
            String price = args[2];
            if (price.length() > 8) {
                price = price.substring(0, 8);
            }
            String quantity = args[3];
            if (quantity.length() > 8) {
                quantity = quantity.substring(0, 8);
            }
            Product main_product = new Product(++max_id, name, price, quantity);
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                writer.write("\n");
                writer.write(main_product.toString());
            }
        }

    }

    public static Product getProduct(String product) {
        int id = Integer.parseInt(product.substring(0, 8).trim());
        String name = product.substring(8, 38).trim();
        String price = product.substring(38, 46).trim();
        String quantity = product.substring(46, 50).trim();
        return new Product(id, name, price, quantity);
    }
}
