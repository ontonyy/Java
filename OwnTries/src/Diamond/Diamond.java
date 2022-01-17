package Diamond;

import java.util.Scanner;

public class Diamond {
    public static void main(String[] args) {
        String diamond = "";
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a symbol: ");
        String symbol = scanner.nextLine();
        System.out.print("Enter an amount of rows: ");
        int n = scanner.nextInt() / 2;
        for (int i = 1; i <= n; i++) {
            diamond += " ".repeat(n - i) + symbol.repeat(i);
            diamond += symbol.repeat(i) + " ".repeat(n - i) + "\n";
        }

        for (int i = n; i >= 0; i--) {
            diamond += " ".repeat(n - i) + symbol.repeat(i);
            diamond += symbol.repeat(i) + " ".repeat(n - i) + "\n";
        }
        System.out.println(diamond);
    }
}
