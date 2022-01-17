package messenger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MessageManager {
    private List<String> messages = new ArrayList<>();

    public MessageManager(List<String> messages) {
        this.messages = messages;
    }

    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public void sendMessage(String message) {
        messages.add(message);
    }

    public void manageResponse() {
        List<String> responseList = new ArrayList<>(
                Arrays.asList("1. See the list of all messages", "2. Send a new message", "3. Go back to the previous menu."));
        responseList.forEach(System.out::println);
        Scanner scanner = new Scanner(System.in);

        switch (scanner.nextLine()) {
            case "1":
                System.out.println(getMessages());
                break;
            case "2":
                System.out.print("Enter message: ");
                sendMessage(new Scanner(System.in).nextLine());
                break;
            case "3":
                break;
            default:
                System.out.println("Try again!");
                manageResponse();
        }
    }
}
