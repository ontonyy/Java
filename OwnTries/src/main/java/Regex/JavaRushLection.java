package Regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class JavaRushLection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = "";
        String str2 = "";

        while (true) {
            if (!(str1 = scanner.nextLine()).equals("")) {
                break;
            }
        }

        while (true) {
            if (!(str2 = scanner.nextLine()).equals("")) {
                break;
            }
        }

        str2 = str2.replaceAll("\\\\n", "\n");
        try {
            System.out.println("regex = " + str1);
            System.out.println("input = " + str2);
            Pattern p = Pattern.compile(str1);
            Matcher m = p.matcher(str2);
            while (m.find())
                System.out.println("Found [" + m.group() + "] starting at "
                        + m.start() + " and ending at " + (m.end() - 1));
        } catch (PatternSyntaxException pse) {
            System.err.println("Неправильное регулярное выражение: " + pse.getMessage());
            System.err.println("Описание: " + pse.getDescription());
            System.err.println("Позиция: " + pse.getIndex());
            System.err.println("Неправильный шаблон: " + pse.getPattern());
        }
        System.out.println("kuka".matches("[a-z]"));
    }
}
