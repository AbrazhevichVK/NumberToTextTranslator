import java.util.Scanner;
import java.util.Map;

public class NumberToTextTranslator {
    public static void main(String[] args) {
        String path = "DeskBook.txt";
        Map<String, String> map = NumberReferenceParser.getNumberReference(path);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter int number: ");
        String number = scanner.next();
        if(number.matches("[-+]?\\d+")){
            System.out.println(NumberProcessor.getNumberAsText(number,  map));
        } else {
            System.out.println("Input error");
        }
    }
}
