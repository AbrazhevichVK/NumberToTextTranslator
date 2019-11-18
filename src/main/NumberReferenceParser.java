package main;

import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class NumberReferenceParser {

    public static Map<String, String> getNumberReferenceBook(String pathway) {
        File file = new File(pathway);
        Scanner scanner;
        Map<String, String> map = new HashMap<String, String>();
        try {
            scanner = new Scanner(file);
            map = createMap(scanner);
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No valid file");
        }
        return map;
    }

    private static Map<String, String> createMap(Scanner scanner) {
        Map<String, String> map = new HashMap<String, String>();
        while (scanner.hasNextLine()) {
            String textread = scanner.nextLine();
            String[] partsOfMap = textread.split(":");
            map.put(partsOfMap[0], partsOfMap[1]);
        }
        return map;
    }
}
