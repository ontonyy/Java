package messenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MessageManager messageManager = new MessageManager(new ArrayList<>());
        ContactManager contactManager = new ContactManager(new ArrayList<>());
        List<String> choosingList = new ArrayList<>(Arrays.asList("1. Manage contacts", "2. Messages", "3. Quit"));
        Scanner scanner = new Scanner(System.in);

        while (true) {
            boolean close = false;
            choosingList.forEach(System.out::println);
            String choose = scanner.nextLine();
            switch (choose) {
                case "1":
                    contactManager.manageResponse();
                    continue;
                case "2":
                    messageManager.manageResponse();
                    continue;
                case "3":
                    close = true;
                    break;
            }
            if (close) {
                break;
            }

        }
    }
}
