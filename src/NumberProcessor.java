import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class NumberProcessor {
    public static String getNumberAsText(String number, Map<String, String> map)
    {
        var triads = getTriads(number);
        ArrayList<String> triadAsText = getTriadsAsText(map, triads);
        String result = new String();
        Collections.reverse(triadAsText);
        for (String treadText:triadAsText) {
            if(treadText==null){
                result+=treadText;
            }else{ result+=treadText+" ";}
        }
        return result.replace("null","").trim();
    }

    private static ArrayList<String> getTriadsAsText(Map<String, String> map, ArrayList<Integer> triads) {
        int currentTriad = 0;
        ArrayList<String> triadAsText = new ArrayList<>();
        for (int triad : triads) {
            currentTriad++;
            int hungreeds = triad/100*100;
            int tens = triad/10%10*10;
            int ones = triad%10;
            if(tens==10 && ones>0){
                tens=0;
                ones = 10+ones;
            }
            String hungreedsText = map.get(String.valueOf(hungreeds));
            String tensText = map.get(String.valueOf(tens));
            String onesText = map.get(String.valueOf(ones));
            var endOfLastNumber = getEndOfLastNumber(ones,currentTriad);
            var triadText = hungreedsText + " " + tensText +" "+onesText+endOfLastNumber;
            triadText = triadText.replace("null","").trim();
            if(currentTriad>1){
                var triadName = map.get(currentTriad+"triad");
                var endOfNumber = getEndOfNumber(ones, currentTriad);
                if (hungreedsText==null && tensText==null&& onesText==null){
                    triadText=null;
                }else{triadText+=" "+triadName+endOfNumber;}

            }
            triadAsText.add(triadText);
        }
        return triadAsText;
    }

    private static ArrayList<Integer> getTriads(String number){
        ArrayList<Integer> triads = new ArrayList<Integer>();
        triads = getPartsAsInt(number,3);
        Collections.reverse(triads);
        return triads;
    }


    private static String getEndOfLastNumber(int number, int triad) {
        if (triad == 2) {
            if (number == 1) {
                return "на";
            }
            if (number == 2) {
                return "е";
            }
        } else {
            if (number == 1) {
                return "ин";
            }
            if (number == 2) {
                return "а";
            }
        }
        return "";
    }

    private static String getEndOfNumber(int number, int triad){
        if(triad==2) {
            switch (number) {
                case 1:
                    return "а";
                case 2:
                    return "и";
                case 3:
                    return "и";
                case 4:
                    return "и";
                default:
                    return "";
            }
        }
        switch (number) {
            case 1:
                return "";
            case 2:
                return "а";
            case 3:
                return "а";
            case 4:
                return "а";
            default:
                return "ов";
        }
    }

    private static ArrayList<Integer> getPartsAsInt(String string, int partitionSize) {
        ArrayList<Integer> triads = new ArrayList<Integer>();
        int len = string.length();
        int remDiff = len%3;
        if(remDiff!=0){
            triads.add(Integer.parseInt(string.substring(0, remDiff)));
        }
        for (int i=remDiff; i<len; i+=partitionSize)
        {
            triads.add(Integer.parseInt(string.substring(i, Math.min(len, i + partitionSize))));
        }
        return triads;
    }
}
