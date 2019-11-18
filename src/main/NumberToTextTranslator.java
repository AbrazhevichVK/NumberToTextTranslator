package main;

import java.util.Scanner;
import java.util.Map;

public class NumberToTextTranslator {
    public static void main(String[] args) {
        String pathway = "DeskBook.txt";
        Map<String, String> map = NumberReferenceParser.getNumberReferenceBook(pathway);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter int number: ");
        String inputNumber = scanner.next();
        if (inputNumber.matches("[-+]?\\d+")) {
            System.out.println("Ответ: " + NumberProcessor.getTranslatedNumberAsText(inputNumber, map));
        } else {
            System.out.println("Input error");
        }
    }
}


