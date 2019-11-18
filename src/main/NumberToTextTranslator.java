package main;
/**
 * Imports for Scanner and Map
 */

import java.util.Scanner;
import java.util.Map;

/**
 * NumberToTextTranslator class used for: starting program, getting InputNumber and sending it to getTranslatedNumberAsText method, sending String variable pathvay to getNumberReferenceBook method;
 *
 * @author AbrazhevichVK
 * @version v.02
 * @since v.01
 */

public class NumberToTextTranslator {
    /**
     * There is a start point of the program and a place, where objects for following methods creates
     *
     * @see NumberReferenceParser#getNumberReferenceBook(String)
     * @see NumberProcessor#getTranslatedNumberAsText(String, Map)
     */
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


