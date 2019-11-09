import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class NumberReferenceParser {

    public static Map<String, String> getNumberReference(String path) {
        File file = new File(path);
        Scanner scanner ;
        Map<String, String> map = new HashMap<String, String>();
        try {
            scanner = new Scanner(file);
            map = createMap(scanner);
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e){
            System.out.println("Unexpected error. "+ e.getMessage());
        }
        return map;
    }

    private  static Map<String, String> createMap(Scanner scanner){
        Map<String, String> map = new HashMap<String, String>();
        while (scanner.hasNextLine()){
            String textread = scanner.nextLine();
            String[] words = textread.split(":");
            map.put(words[0], words[1]);
        }
        return map;
    }
}
