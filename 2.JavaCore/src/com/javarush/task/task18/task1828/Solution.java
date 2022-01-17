package com.javarush.task.task18.task1828;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Прайсы 2
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

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                Product pro = getProduct(reader.readLine());
                products.add(pro);
            }
        }
        switch (args[0]) {
            case "-d": {
                for (Product p : products) {
                    if (args[1].equals(Integer.toString(p.id))) {
                        products.remove(p);
                    }
                }
                break;
            }
            case "-u": {
                for (Product p: products) {
                    if (p.id == Integer.parseInt(args[1])) {
                        p.name = args[2];
                        p.price = args[3];
                        p.quantity = args[4];
                    }
                }
                break;
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product: products) {
                writer.write(product.toString());
                writer.write("\n");
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
