import java.io.File;
import  java.util.Arrays;
import java.util.Scanner;
import java.util.HashMap;
import java.io.FileNotFoundException;
import java.util.Map;

public class NumberToTextTranslator {
    public static void main(String[] args) {
        String path = "DeskBook.txt";
        Map<String, String> map = NumberReferenceParser.getNumberReference(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter int number: ");
        int number = scanner.nextInt();


    }
}
