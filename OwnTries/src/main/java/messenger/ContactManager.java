package messenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private List<String> contacts = new ArrayList<>();

    public ContactManager(List<String> contacts) {
        this.contacts = contacts;
    }

    public List<String> showContacts() {
        return contacts;
    }

    public void setContacts(List<String> contacts) {
        this.contacts = contacts;
    }

    public void addContact(String contact) {
        contacts.add(contact);
    }

    public void deleteContact(String contact) {
        if (contacts.contains(contact)) {
            contacts.remove(contact);
        } else {
            System.out.println("Contact not found");
        }
    }

    public void searchContact(String contact) {
        if (contacts.contains(contact)) {
            System.out.println(contact + " founden in " + contacts.indexOf(contact) + " position.");
        } else {
            System.out.println("Contact not found");
        }
    }

    public void manageResponse() {
        List<String> responseList = new ArrayList<>(
                Arrays.asList("1. Show all contacts", "2. Add new contact", "3. Search for a contact", "4. Delete a contact", "5. Go back to the previous menu."));
        responseList.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextLine()) {
            case "1":
                System.out.println(showContacts());
                break;
            case "2":
                System.out.print("Enter contact for add: ");
                addContact(new Scanner(System.in).nextLine());
                break;
            case "3":
                System.out.print("Enter contact for search: ");
                searchContact(new Scanner(System.in).nextLine());
                break;
            case "4":
                System.out.print("Enter contact for delete: ");
                deleteContact(new Scanner(System.in).nextLine());
                break;
            case "5":
                break;
            default:
                System.out.println("Try again!");
                manageResponse();
        }
    }

}
